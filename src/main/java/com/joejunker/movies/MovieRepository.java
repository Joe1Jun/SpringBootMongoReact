package com.joejunker.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// This annotation marks the interface as a Spring Data repository.
// It indicates that this interface is a Spring component and is eligible for Spring Data
// repository support, allowing it to interact with MongoDB.
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    // This interface extends MongoRepository, which provides CRUD operations for the Movie entity.
    // The generic parameters specify:
    // 1. Movie: The type of the entity that this repository manages.
    // 2. ObjectId: The type of the identifier (ID) for the entity.
    
    // By extending MongoRepository, MovieRepository inherits methods for:
    // - Saving entities (create and update)
    // - Deleting entities
    // - Finding entities by their ID
    // - Finding all entities
    // Additional custom query methods can be defined here if needed.
}
