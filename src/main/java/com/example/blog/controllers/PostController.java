package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex() {
        return ("posts index page");
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String indPostView(@PathVariable int id) {
        return ("view an individual post: " + id);
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreateForm() {
        return ("view the form for creating a post");
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String makeNewPost() {
        return ("create a new post");
    }


}
