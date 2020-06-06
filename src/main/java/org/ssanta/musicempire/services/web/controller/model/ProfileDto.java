package org.ssanta.musicempire.services.web.controller.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto implements Serializable{

	 
	private static final long serialVersionUID = -3172608747795738134L;
	
	private String id;
	private String name;
	private String profile;
	
}
