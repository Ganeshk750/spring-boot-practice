package com.ganesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.Tutorial;
import com.ganesh.repository.TutorialRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TutorialController {
	
	private final TutorialRepository tutorialRepository;
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title){
		List<Tutorial> tutlist = tutorialRepository.findByTitleContaning(title);
		return ResponseEntity.ok(tutlist);
	}
	

	  @GetMapping("/tutorials/{id}")
	  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") String id) {
	    Optional<Tutorial> singleTute = tutorialRepository.findById(id);
	    Tutorial tutorial = null;
	    if(singleTute.isPresent()) {
	    	tutorial = singleTute.get();
	    }else {
	    	throw new RuntimeException("No Tutorails Found with this id: "+ id);
	    }
	    return new ResponseEntity<Tutorial>(tutorial, HttpStatus.OK);
	  }

	  @PostMapping("/tutorials")
	  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
		  Tutorial newTutorail = tutorialRepository.insert(tutorial);
	      return new ResponseEntity<Tutorial>(newTutorail, HttpStatus.CREATED);
	  }

	  @PutMapping("/tutorials/{id}")
	  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
		  Optional<Tutorial> singleTute = tutorialRepository.findById(id);
		    Tutorial tutl = null;
		    if(singleTute.isPresent()) {
		    	tutl = singleTute.get();
		    	Tutorial newtutorial = new Tutorial();
		    	newtutorial.setTitle(tutl.getTitle());
		    	newtutorial.setDescription(tutl.getDescription());
		    	newtutorial.setPublished(tutl.isPublished());
		    	tutorialRepository.insert(newtutorial);
		    }else {
		    	throw new RuntimeException("No Tutorails Found with this id: "+ id);
		    }
		    return new ResponseEntity<Tutorial>(tutl, HttpStatus.OK); 
	  }

	  @DeleteMapping("/tutorials/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
		  Optional<Tutorial> singleTute = tutorialRepository.findById(id);
		    if(singleTute.isPresent()) {
		    	tutorialRepository.deleteById(id);
		    }else {
		    	throw new RuntimeException("No Tutorails Found with this id: "+ id);
		    } 
		    return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	  }

	  @DeleteMapping("/tutorials")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
	    tutorialRepository.deleteAll();
	    return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	  }

	  
	  @GetMapping("/tutorials/published")
	  public ResponseEntity<List<Tutorial>> findByPublishedTutorials() {
		 boolean published = true;
	     List<Tutorial> tutorialList = tutorialRepository.findByPublished(published); 
	     return new ResponseEntity<List<Tutorial>>(tutorialList, HttpStatus.OK);
	  }
	
	

}
