package org.ssanta.musicempire.services.web.controller.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverDto implements Serializable {
	 
	private static final long serialVersionUID = -5103870745913888274L;

	private String release;
	
	private List<CoverImageDto> images;
}
