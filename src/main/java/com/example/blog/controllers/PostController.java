package com.example.blog.controllers;

import com.example.blog.models.Categories;
import com.example.blog.models.Post;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {


    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/")
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
        newPost.setUser(userDao.findOne((long)2));
        postDao.save(newPost);
        return "redirect:/";
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
        editPost.setUser(userDao.findOne((long)2));
        postDao.save(editPost);
        return "redirect:/";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post deletePost){
        postDao.delete(deletePost);
        return "redirect:/";
    }


}
