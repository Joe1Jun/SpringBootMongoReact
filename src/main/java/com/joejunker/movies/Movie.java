package com.joejunker.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

//This defines this class as the model for the collection called movies. Basically sets this as the template for the collection objects
@Document(collection = "movies")
//Lombok : this generates to string and getters and setters automatically 
@Data
// Creates a constructor automatically
@AllArgsConstructor
// Creates a no argument constructor automatically
@NoArgsConstructor
public class Movie {
	//This annotation sets the instacne variable below it as the unique identifier for the objects in this class 
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;
    //This annotation sets the instance variable below it as a reference usually in the from of a unique id such as object ID
    //This id is created in the class of the object specified in the list . Here this is the Review object
    @DocumentReference
    private List<Review> reviewIds;
	
    
    
    

    
}