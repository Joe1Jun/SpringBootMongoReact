package com.joejunker.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/// This annotation marks the class as a Spring REST controller.
//It allows the class to handle HTTP requests and return responses.
@RestController
@RequestMapping("/api/v1/movies") // This specifies the base URI for all requests handled by this controller.
public class MovieController {

 // This annotation automatically injects the MovieService bean into this controller.
 @Autowired
 private MovieService service;

 // This method handles GET requests to the /api/v1/movies endpoint.
 @GetMapping
 public ResponseEntity<List<Movie>> getMovies() {
     // Calls the service to retrieve the list of all movies.
     // The service layer typically handles business logic and data retrieval.
     
     List<Movie> movies = service.findAllMovies();

     // Returns a ResponseEntity containing the list of movies with an HTTP status of OK (200).
     return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
 }
}