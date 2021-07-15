package com.ganesh.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.model.Tutorial;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
   
	/* findByTitleContaining(): returns all Tutorials which title contains input title */
	List<Tutorial> findByTitleContaning(String title);
	
	/* findByPublished(): returns all Tutorials with published having value as input published */
	List<Tutorial> findByPublished(boolean pulished);
}
