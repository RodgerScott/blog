package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repositories.PostRepository;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


    private final PostRepository postDao;


    public PostController (PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("posts")
    public String postsIndex(Model model) {
            model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("posts/{id}")
    public String indPostView(@PathVariable long id, Model model) {

        model.addAttribute("post", postDao.findOne(id));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(Model viewModel) {
        viewModel.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String makeNewPost(@ModelAttribute Post newPost) {
        postDao.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/rick-roll")
    public String rickRoll() {
        // redirecting to an absolute url
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost (Model model, @PathVariable long id) {
        model.addAttribute("post", postDao.findOne(id));

        return "/posts/edit";
    }
    
    @PostMapping("/posts/edit")
    public String makeEdit(@ModelAttribute Post editPost){
        postDao.save(editPost);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post deletePost){
        postDao.delete(deletePost);
        return "redirect:/posts";
    }


}
