package com.joejunker.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This annotation is used to tell Spring Boot that the class is a RESTful controller. It indicates that this class
//will handle HTTP requests and responses in a REST API.
@RestController
//This annotation maps HTTP requests to specific methods or classes. In this case, it's mapping all routes that start with /api/v1/movies to this controller. Any endpoint 
//defined inside this class will have /api/v1/movies as the base URL.
@RequestMapping("/api/v1/movies")

public class MovieController {
	
	@GetMapping
	//ResponseEntity is used to have control over the HTTP response body 
	//and status code, similar to how you handle responses in Node.js with res.status().send().
      public ResponseEntity<String> getAllMovies () {
		
		return new ResponseEntity<String>("All Movies", HttpStatus.OK);
		
	}

}
