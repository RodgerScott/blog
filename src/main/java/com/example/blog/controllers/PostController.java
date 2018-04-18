package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    PostService postService;

    public PostController (PostService postService) {
        this.postService = postService;
    }

    @GetMapping("posts")
    public String postsIndex(Model model) {

            model.addAttribute("posts", postService.all());

        return "posts/index";
    }

    @GetMapping("posts/{id}")
    public String indPostView(@PathVariable long id, Model model) {

        model.addAttribute("post", postService.indPost(id));

        return "posts/show";
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
