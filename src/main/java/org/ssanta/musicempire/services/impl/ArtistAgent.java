package org.ssanta.musicempire.services.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.ssanta.musicempire.services.IArtistAgent;
import org.ssanta.musicempire.services.web.controller.model.ArtistMaterialDto;

import lombok.extern.slf4j.Slf4j;

@ConfigurationProperties(prefix = "org.ssanta.musicbrainz", ignoreUnknownFields = false)
@Slf4j
@Component
public class ArtistAgent implements IArtistAgent{

    public static final String ARTIST_PATH = "ws/2/artist/{mbid}";
    private final RestTemplate restTemplate;
    private String host;
    
    private static final String RELEASE_GROUP = "release-groups";
    private static final String RELATIONS = "url-rels";
    
    
    
    public ArtistAgent (RestTemplateBuilder inRestTemplateBuilder) {
    	restTemplate = inRestTemplateBuilder
    				.errorHandler(new DefaultResponseErrorHandler())
    				.build();
    }
	 

	public void setHost(String host) {
		this.host = host;
	}


	@Override
	public ArtistMaterialDto getArtistMaterialDto(String inMBID) {

		ArtistMaterialDto material = fetchArtistMaterial(inMBID);
		log.info("getting music material: " + material);

		return material;

	}
	
	private ArtistMaterialDto fetchArtistMaterial(String inMBID) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(host)
				.path(ARTIST_PATH)
				.queryParam("inc", RELEASE_GROUP+"+"+RELATIONS)
		        .queryParam("fwt", "json");
		
		String url = builder.build().toUriString();
		        

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<ArtistMaterialDto> response = restTemplate.exchange(
				url, 
		        HttpMethod.GET, 
		        entity, 
		        ArtistMaterialDto.class,
		        inMBID);
		
		return response.getBody();
	}

}
