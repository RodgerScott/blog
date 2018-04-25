package com.example.blog.controllers;

import com.example.blog.models.Categories;
import com.example.blog.models.Comment;
import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.repositories.CategoriesRepository;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {


    private final PostRepository postDao;
    private final UserRepository userDao;
    private final CategoriesRepository categoriesDao;

    public PostController(PostRepository postDao, UserRepository userDao, CategoriesRepository categoriesDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.categoriesDao = categoriesDao;
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

    @PostMapping("/posts/comment")
    public String addComment (@ModelAttribute Post post, Model model, Comment newComment) {
        model.addAttribute("newComment", newComment);
        model.addAttribute("id", post.getId());
        postDao.save(post);
        return "posts/{id}";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(Model viewModel) {
        viewModel.addAttribute("newPost", new Post());
        Iterable<Categories> categories = categoriesDao.findAll();
        viewModel.addAttribute("categories", categories);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String makeNewPost(@Valid Post newPost, Errors validation, Model model) {
        if (validation.hasErrors()) {
            model.addAttribute("newPost", newPost);
            Iterable<Categories> categories = categoriesDao.findAll();
            model.addAttribute("categories", categories);
            return "posts/create";
        }

        User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newPost.setUser(current);
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
        Iterable<Categories> categories = categoriesDao.findAll();
        model.addAttribute("categories", categories);

        return "/posts/edit";
    }
    
    @PostMapping("/posts/edit")
    public String makeEdit(@Valid Post editPost, Errors validation, Model model){
        if (validation.hasErrors()) {
            model.addAttribute("editPost", editPost);
            Iterable<Categories> categories = categoriesDao.findAll();
            model.addAttribute("categories", categories);
            return "posts/edit";
        }

        User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        editPost.setUser(current);
        postDao.save(editPost);
        return "redirect:/";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post deletePost){
        postDao.delete(deletePost);
        return "redirect:/";
    }


}
