package com.joejunker.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This annotation marks the class as a Spring Service.
// A service in Spring typically contains business logic and interacts with the repository layer.
@Service
public class MovieService {

    // This annotation allows Spring to automatically inject the MovieRepository bean
    // into this service, providing access to data-related operations.
    @Autowired
    private MovieRepository movieRepository;

    // This method retrieves all movies from the repository.
    // It calls the findAll() method on the repository to fetch the data.
    public List<Movie> findAllMovies() {
        // Calls the repository's findAll method to get the list of movies
        return movieRepository.findAll();
    }

    
    public Optional<Movie> singleMovie(String imbdId) {
        // The method tries to find a Movie by its ObjectId.
        // It returns an Optional<Movie>:
        // - If a movie with the given ID exists, the Optional contains the Movie object.
        // - If no movie is found, the Optional is empty, indicating the absence of a value.
        return movieRepository.findMovieByImdbId(imbdId);
    }
}
