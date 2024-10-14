package com.joejunker.movies;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movie {
	
	@Id
	//This id annotation when placed above a variable indicates that this is the unique 
	// identifier for each movie object
	private Object id;
	private String imbdId;
	private String title;
	private String releaseDate;
	private String trailerLink;
	private String poster;
	private List<String> genres;
	private List <String> backdrops;
	

}
