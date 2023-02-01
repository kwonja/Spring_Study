package com.kwon.joblisting.controller;

import com.kwon.joblisting.repository.PostRepository;
import com.kwon.joblisting.model.Post;
import com.kwon.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository srepo;

    @GetMapping("/posts")
    public List<Post> getAllPost()
    {
        return repo.findAll();
    }
    @GetMapping("/")
    public String Hello()
    {
        return "hello";
    }
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
    //posts//java
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }

}
