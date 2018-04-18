package com.example.blog.services;

import com.example.blog.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;



@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }


    public void createPosts() {
        posts.add(new Post("Title 1", "Description 1", 1));
        posts.add(new Post("Title 2", "Description 1", 2));
        posts.add(new Post("Title 3", "Description 1", 3));
        posts.add(new Post("Title 4", "Description 1", 4));
    }

    public List<Post> all() {

        return posts;
    }

    public Post indPost(long id) {

        return (Post) posts.get(((int) id) - 1);
    }

}