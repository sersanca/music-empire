package org.ssanta.musicempire.services.web.controller.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistMaterialDto implements Serializable{
 
	private static final long serialVersionUID = 9001262674015582548L;
	
	private String name;
	private String id;
	private String type;
	
	
	@JsonProperty("release-groups")
	private List<ReleaseGroupDto> releaseGroups;
	
	@JsonProperty("relations")
	private List<RelationDto> relations;
	
	public Optional<String> findRelationIdByType(String inType) {
		if (relations != null) {
			for (RelationDto relation : relations) {
				if (inType.equals(relation.getType()) && relation.getUrlDto().getResource() != null) {
					id = relation.getUrlDto().getResource().substring(relation.getUrlDto().getResource().lastIndexOf('/')+1);
					return Optional.of(id);
				}
			}
		}
		return Optional.empty();
	}
	
	
	

}
