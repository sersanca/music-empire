package org.ssanta.musicempire.services.web.controller.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistDto {

	String MBID;
	String description;
	List<AlbumDto> albums;
}
