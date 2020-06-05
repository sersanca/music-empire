package org.ssanta.musicempire.services.web.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RelationDto {
	private String type;
	
	@JsonProperty("url")
	private UrlDto UrlDto;
}
