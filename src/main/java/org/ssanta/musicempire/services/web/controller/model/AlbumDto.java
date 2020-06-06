package org.ssanta.musicempire.services.web.controller.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumDto implements Serializable {
 
	private static final long serialVersionUID = -2132228385543532428L;
	
	private String title;
	 private String coverLink;
	 private String id;
	 
}
