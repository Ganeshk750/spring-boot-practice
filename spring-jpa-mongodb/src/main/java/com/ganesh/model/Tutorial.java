package com.ganesh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "tutorials")
public class Tutorial {
	
	@Id
	@Field("tutorial_id")
	private String id;
	
	@Field("title")
	private String title;
	@Field("description")
	private String description;
	@Field("published")
	private boolean published;

}
