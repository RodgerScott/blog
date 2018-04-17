package com.example.blog.controllers;

import com.example.blog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("posts/index")
    public String postsIndex(Model model) {
        List<Post> posts = new ArrayList<>();

        Post post1 = new Post();
            post1.setTitle("First Test Post");
            post1.setBody("Sample body");

        Post post2 = new Post();
            post2.setTitle("Second Test Post");
            post2.setBody("Sample body");

            posts.add(post1);
            posts.add(post2);

            model.addAttribute("posts", posts);


        return "posts/index";
    }

    @GetMapping("posts/show")
    public String indPostView(Model model) {

        Post post1 = new Post();
        post1.setTitle("First Test Post");
        post1.setBody("Sample body");

        model.addAttribute("post1", post1);

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
