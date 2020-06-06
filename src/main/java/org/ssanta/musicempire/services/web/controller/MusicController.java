package org.ssanta.musicempire.services.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssanta.musicempire.services.IMusicService;
import org.ssanta.musicempire.services.web.controller.model.ArtistDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class MusicController {

	private final IMusicService musicService;

	@GetMapping("artist/{mbid}")
	public ResponseEntity<ArtistDto> getArtistInfo(@PathVariable("mbid") String inMBID) {
		log.info("Getting request: " + inMBID);
		 
		return new ResponseEntity<>(musicService.getArtistInfo(inMBID), HttpStatus.OK);
		 

	}

}
