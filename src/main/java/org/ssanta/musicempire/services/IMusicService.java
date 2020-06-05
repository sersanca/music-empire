package org.ssanta.musicempire.services;

import org.ssanta.musicempire.services.web.controller.model.ArtistDto;

public interface IMusicService {

	ArtistDto getArtistInfo(String inMBID);
}
