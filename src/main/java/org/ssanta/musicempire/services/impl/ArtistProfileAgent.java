package org.ssanta.musicempire.services.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.ssanta.musicempire.services.IArtistProfileAgent;
import org.ssanta.musicempire.services.web.controller.model.ProfileDto;

import lombok.extern.slf4j.Slf4j;

@ConfigurationProperties(prefix = "org.ssanta.discogs", ignoreUnknownFields = false)
@Slf4j
@Component
public class ArtistProfileAgent implements IArtistProfileAgent{

	public static final String PATH = "artists/{id}";
	private final RestTemplate restTemplate;
	private String host;

	public void setHost(String host) {
		this.host = host;
	}


	public ArtistProfileAgent(RestTemplateBuilder inRestTemplateBuilder) {
		restTemplate = inRestTemplateBuilder.build();
	}


	@Override
	public String getArtistProfile(String inId) {
		
		log.info("fetching profile for : " + inId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(host)
				.path(PATH);
			
		        
		
		String url = builder.build().toUriString();
		        

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<ProfileDto> response = restTemplate.exchange(
				url, 
		        HttpMethod.GET, 
		        entity, 
		        ProfileDto.class,
		        inId);
		
		return response.getBody().getProfile();
		
	}

}
