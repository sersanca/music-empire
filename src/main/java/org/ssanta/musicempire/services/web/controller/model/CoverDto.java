package org.ssanta.musicempire.services.web.controller.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverDto {
	private String release;
	
	private List<CoverImageDto> images;
}
