package org.ssanta.musicempire.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ssanta.musicempire.services.IArtistAgent;
import org.ssanta.musicempire.services.web.controller.model.ArtistMaterialDto;

@SpringBootTest
public class ArtistAgentTest {
	@Autowired
	IArtistAgent client;
	private static final String MBID_1 = "cc197bad-dc9c-440d-a5b5-d52ba2e14234";

	@Test
	void getMusicInfo() {
		ArtistMaterialDto info = client.getArtistMaterialDto(MBID_1).get();
		
		System.out.println(info);


		assertNotNull(info);

	}
}
