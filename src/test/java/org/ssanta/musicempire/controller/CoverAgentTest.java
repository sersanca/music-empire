package org.ssanta.musicempire.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ssanta.musicempire.services.IArtistAgent;
import org.ssanta.musicempire.services.ICoverAgent;
import org.ssanta.musicempire.services.web.controller.model.ArtistMaterialDto;
import org.ssanta.musicempire.services.web.controller.model.CoverDto;

@SpringBootTest
public class CoverAgentTest {
	@Autowired
	ICoverAgent client;
	private static final String ALBUM_ID_1 = "1dc4c347-a1db-32aa-b14f-bc9cc507b843";

	@Test
	void getMusicInfo() {
		CoverDto info = client.getCover(ALBUM_ID_1);

		System.out.println(info);

		assertNotNull(info);

	}
}
