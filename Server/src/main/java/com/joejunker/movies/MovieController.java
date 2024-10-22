package com.joejunker.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/// This annotation marks the class as a Spring REST controller.
//It allows the class to handle HTTP requests and return responses.
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/movies") // This specifies the base URI for all requests handled by this controller.
public class MovieController {

 // This annotation automatically injects the MovieService bean into this controller.
 @Autowired
 private MovieService movieService;

 // This method handles GET requests to the /api/v1/movies endpoint.
 @GetMapping
 public ResponseEntity<List<Movie>> getMovies() {
     // Calls the service to retrieve the list of all movies.
     // The service layer typically handles business logic and data retrieval.
     
  

     // Returns a ResponseEntity containing the list of movies with an HTTP status of OK (200).
     return new ResponseEntity<List<Movie>>(movieService.findAllMovies(), HttpStatus.OK);
 }
 
 @GetMapping("/{imdbId}") // // Maps GET requests to /api/v1/movies/{id} to this method
 public ResponseEntity<Optional <Movie>> getSingleMovie (@PathVariable  String imdbId){
	 
	// The 'id' parameter is extracted from the URL path and automatically converted to ObjectId

	// Call the service method to retrieve a movie by its imbdId
	// Return a ResponseEntity containing the movie (if found) and HTTP status OK (200)
	 return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
	 
	 
	
 }
 
 
}