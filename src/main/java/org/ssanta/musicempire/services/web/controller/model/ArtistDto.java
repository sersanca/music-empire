package org.ssanta.musicempire.services.web.controller.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistDto implements Serializable {

 
	private static final long serialVersionUID = -7064659961824869448L;
	
	String MBID;
	String description;
	List<AlbumDto> albums;
}
