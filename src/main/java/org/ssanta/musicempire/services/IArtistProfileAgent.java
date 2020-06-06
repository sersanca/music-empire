package org.ssanta.musicempire.services;

import java.util.Optional;

public interface IArtistProfileAgent {
	Optional<String> getArtistProfile(String inId);
}
