package com.joejunker.movies;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This is the same as using @Entity for relational databases
// We have to clarify the collection name here as with noSql there is no table
// automatically created from the class object just a collection object 
@Document(collection = "movies")
//This generated all getters and setters for all non final instance variables
// Also creates toString method hashcode and equals methods for all instance variables
@Data
//@AllArgsConstructor: Generates a constructor like public Movie(String id, String title, String director).
@AllArgsConstructor
//@NoArgsConstructor: Generates a no-argument constructor like public Movie().
@NoArgsConstructor
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
	
	// This annotation will create ids or refernces to the reviews and the reviews will be 
	// stored in a separate collection
	@DocumentReference
	private List<Review> reviewIds;
	
	
	

}
