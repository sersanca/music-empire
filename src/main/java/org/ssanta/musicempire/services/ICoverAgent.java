package org.ssanta.musicempire.services;

import java.util.Optional;

import org.ssanta.musicempire.services.web.controller.model.CoverDto;

/**
 * Component to provide additional information for a given album
 * @author sergio
 *
 */
public interface ICoverAgent {
	
	Optional<CoverDto> getCover(String inAlbumId);
}
