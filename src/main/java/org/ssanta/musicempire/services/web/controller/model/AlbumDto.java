package org.ssanta.musicempire.services.web.controller.model;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumDto {
	 private String title;
	 private OffsetDateTime releaseDate; 
	 private String coverLink;
	 private String id;
	 
}
