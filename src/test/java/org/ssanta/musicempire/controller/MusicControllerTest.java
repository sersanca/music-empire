package org.ssanta.musicempire.controller;


 
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.ssanta.musicempire.services.IMusicService;
import org.ssanta.musicempire.services.web.controller.MusicController;
import org.ssanta.musicempire.services.web.controller.NotFoundException;
import org.ssanta.musicempire.services.web.controller.model.ArtistDto;


@WebMvcTest(MusicController.class)
public class MusicControllerTest {
	
	@MockBean
	IMusicService musicService;
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void getArtistInfo() throws Exception {

		given(musicService.getArtistInfo(any())).willReturn(getRandomArtist());

		mockMvc.perform(get("/api/v1/artist/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	

	@Test
	void getInvalidArtistInfo() throws Exception {

		given(musicService.getArtistInfo(any())).willThrow(NotFoundException.class);

		mockMvc.perform(get("/api/v1/artist/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

	}
	  
    private ArtistDto getRandomArtist() {
		 return ArtistDto.builder()
		  	.MBID("random-id-12323-123213-3344")
		  	.description("Michel Jackson")
		  	.build();
	  }

}
