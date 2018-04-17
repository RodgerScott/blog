package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String hello() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String greetings(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("home/users")
    public String welcomeUsers(Model model) {

        List<String> users = new ArrayList<>();

        users.add("Sally");
        users.add("Geoff");
        users.add("Steve");


        model.addAttribute("users", users);


        return "home";
    }

}


