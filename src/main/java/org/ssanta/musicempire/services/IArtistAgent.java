package org.ssanta.musicempire.services;

import java.util.Optional;

import org.ssanta.musicempire.services.web.controller.model.ArtistMaterialDto;

/**
 * Component to provide extra information about the given artist
 * @author sergio
 *
 */
public interface IArtistAgent {

	Optional<ArtistMaterialDto> getArtistMaterialDto(String inMBID);
}
