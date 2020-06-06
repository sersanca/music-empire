package org.ssanta.musicempire.services.web.controller.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverImageDto implements Serializable {
 
	private static final long serialVersionUID = 1754568308448703463L;

	private String id;
	
	@JsonProperty("image")
	private String imageLink;
}
