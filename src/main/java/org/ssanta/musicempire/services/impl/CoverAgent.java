package org.ssanta.musicempire.services.impl;

import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.ssanta.musicempire.services.ICoverAgent;
import org.ssanta.musicempire.services.web.controller.model.CoverDto;

import lombok.extern.slf4j.Slf4j;

@ConfigurationProperties(prefix = "org.ssanta.coverart", ignoreUnknownFields = false)
@Slf4j
@Component
public class CoverAgent implements ICoverAgent{

	public static final String COVER_ART_PATH = "release-group/{idß}";
	private final RestTemplate restTemplate;
	private String host;

	public CoverAgent(RestTemplateBuilder inRestTemplateBuilder) {
		restTemplate = inRestTemplateBuilder.build();
	}

	
	
	 
	public void setHost(String host) {
		this.host = host;
	}




	@Override
	public Optional<CoverDto> getCover(String inAlbumId) {
		log.info("getting cover for " +inAlbumId);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(host)
				.path(COVER_ART_PATH);
			
		        
		
		String url = builder.build().toUriString();
		        

		HttpEntity<?> entity = new HttpEntity<>(headers);

		try {
			
			HttpEntity<CoverDto> response = restTemplate.exchange(
					url, 
			        HttpMethod.GET, 
			        entity, 
			        CoverDto.class,
			        inAlbumId);
			
			return Optional.ofNullable(response.getBody());
			
			
		}catch(RestClientException e) {
			log.error(e.getMessage());
			return Optional.empty();
		}
		
		
		
	}

}
