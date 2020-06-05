package org.ssanta.musicempire.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ssanta.musicempire.services.IArtistAgent;
import org.ssanta.musicempire.services.IArtistProfileAgent;
import org.ssanta.musicempire.services.ICoverAgent;
import org.ssanta.musicempire.services.web.controller.model.ArtistMaterialDto;
import org.ssanta.musicempire.services.web.controller.model.CoverDto;

@SpringBootTest
public class ProfileAgentTest {
	@Autowired
	IArtistProfileAgent client;
	private static final String ID = "29735";

	@Test
	void getMusicInfo() {
		String info = client.getArtistProfile(ID);
		System.out.println(info);

		assertNotNull(info);

	}
}
