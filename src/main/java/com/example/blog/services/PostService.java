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
        this.save(new Post("Title 1", "Description 1"));
        this.save(new Post("Title 2", "Description 2"));
        this.save(new Post("Title 3", "Description 3"));
        this.save(new Post("Title 4", "Description 4"));
    }

    public void save(Post newPost) {
        newPost.setId(this.posts.size()+ 1);
        this.posts.add(newPost);
    }

    public void update(Post newPost) {
        newPost.setId(newPost.getId());
        newPost.setTitle(newPost.getTitle());
        newPost.setBody(newPost.getBody());
    }

    public List<Post> all() {

        return posts;
    }

    public Post indPost(long id) {

        return posts.get(((int) id) - 1);
    }

}