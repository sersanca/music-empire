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
public class ReleaseGroupDto implements Serializable {
 
	private static final long serialVersionUID = -3376588889824757017L;
    private String title;
    private String id;
   
}
