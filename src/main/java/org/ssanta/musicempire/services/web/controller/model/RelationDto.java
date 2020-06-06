package org.ssanta.musicempire.services.web.controller.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RelationDto implements Serializable {
 
	private static final long serialVersionUID = -8035879916970180328L;

	private String type;
	
	@JsonProperty("url")
	private UrlDto UrlDto;
}
