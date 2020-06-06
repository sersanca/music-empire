package org.ssanta.musicempire.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.ssanta.musicempire.services.IArtistAgent;
import org.ssanta.musicempire.services.IArtistProfileAgent;
import org.ssanta.musicempire.services.ICoverAgent;
import org.ssanta.musicempire.services.IMusicService;
import org.ssanta.musicempire.services.web.controller.NotFoundException;
import org.ssanta.musicempire.services.web.controller.model.AlbumDto;
import org.ssanta.musicempire.services.web.controller.model.ArtistDto;
import org.ssanta.musicempire.services.web.controller.model.ArtistMaterialDto;
import org.ssanta.musicempire.services.web.controller.model.CoverDto;
import org.ssanta.musicempire.services.web.controller.model.ReleaseGroupDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service
public class MusicService implements IMusicService {
	
	final ICoverAgent coverAgent;
	final IArtistAgent artistAgent;
	final IArtistProfileAgent profileAgent;
	private static final String DISCOG_TYPE = "discogs";
	
	@Cacheable(cacheNames="artistCache", key="#inMBID")
	@Override
	public ArtistDto getArtistInfo(String inMBID) throws NotFoundException {
	   
		log.info("Requestig artist info for  " + inMBID);
		ArtistDto artist =null;
		ArtistMaterialDto artistMaterial = artistAgent.getArtistMaterialDto(inMBID).orElseThrow(NotFoundException::new);

		artist = new ArtistDto();
		List<AlbumDto> albums = new ArrayList<>();
		if (artistMaterial.getReleaseGroups() != null) {
			for (ReleaseGroupDto release : artistMaterial.getReleaseGroups()) {
				AlbumDto album = AlbumDto.builder()
						.title(release.getTitle())
						.id(release.getId())
						.build();

				enrichAlbum(album);
				albums.add(album);

			}
		}
		artist.setAlbums(albums);
		artist.setMBID(inMBID);

		Optional<String> relationId = artistMaterial.findRelationIdByType(DISCOG_TYPE);
		if (relationId.isPresent()) {
			artist.setDescription(profileAgent.getArtistProfile(relationId.get()).orElse("Not found"));
		}

		log.info("done. All information fetched. -> " + artist);

		return artist;

	}
	
	private void enrichAlbum(AlbumDto inAlbum) {
		
		Optional<CoverDto> cover = coverAgent.getCover(inAlbum.getId());
		if (cover.isPresent() && cover.get().getImages()!=null && cover.get().getImages().size() > 0) {
			//We setup just on image link per album.
			inAlbum.setCoverLink(cover.get().getImages().get(0).getImageLink());
		}
		else {
			inAlbum.setCoverLink("Not available");
		}
		
		

	}

}
