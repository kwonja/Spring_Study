package com.kwon.joblisting.repository;

import com.kwon.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String>{


}
