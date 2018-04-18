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
    public String viewCreateForm(Model viewModel) {
        viewModel.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String makeNewPost(@ModelAttribute Post newPost) {
        postService.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/rick-roll")
    public String rickRoll() {
        // redirecting to an absolute url
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost (Model model, @PathVariable long id) {
        model.addAttribute("post", postService.indPost(id));

        return "/posts/edit";
    }
    
    @PostMapping("/posts/edit")
    public String makeEdit(@ModelAttribute Post editPost){
        long id = editPost.getId();
        editPost.setId(id);
        editPost.setTitle(editPost.getTitle());
        editPost.setBody(editPost.getBody());
        return "redirect:/posts";
    }


}
