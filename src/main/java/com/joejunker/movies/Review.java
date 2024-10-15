package com.joejunker.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Specifies this class as a collection in the Mongo database
@Document(collection = "reviews")
//Lombok generates methods toString, hashcode, equals getters and setters.
@Data
//@AllArgsConstructor: Generates a constructor like public Movie(String id, String title, String director).
@AllArgsConstructor
//@NoArgsConstructor: Generates a no-argument constructor like public Movie().
@NoArgsConstructor
public class Review {
   
	
	@Id
	private ObjectId id;
	
	
}
