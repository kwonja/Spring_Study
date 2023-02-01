package com.kwon.joblisting.repository;

import com.kwon.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
