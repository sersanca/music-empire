package org.ssanta.musicempire.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.ssanta.musicempire.services.IArtistAgent;
import org.ssanta.musicempire.services.IArtistProfileAgent;
import org.ssanta.musicempire.services.ICoverAgent;
import org.ssanta.musicempire.services.IMusicService;

@SpringBootTest
public class MusicServiceTest {
	@Autowired
	IMusicService service;

	@MockBean
	ICoverAgent coverAgent;
	@MockBean
	IArtistAgent artistAgent;
	
	@MockBean
	IArtistProfileAgent profileAgent;
	
	private static final String ALBUM_ID_1 = "1dc4c347-a1db-32aa-b14f-bc9cc507b843";

	@Test
	void getMusicInfo() {
//		CoverD/to info = client.getCover(ALBUM_ID_1);
//
//		System.out.println(info);
//
//		assertNotNull(info);

	}
}
