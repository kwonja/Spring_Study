package com.kwon.joblisting.repository;

import com.kwon.joblisting.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentsRepository extends MongoRepository<Comment,String> {
}
