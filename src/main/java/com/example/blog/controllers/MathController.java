package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.PermitAll;

@Controller
public class MathController {

    @GetMapping("/add/{number1}/and/{number2}")
    @ResponseBody
    public String addNumbers(@PathVariable int number1, @PathVariable int number2) {
        return ("The sum is: " + (number1 + number2));
    }

    @GetMapping("/subtract/{number1}/from/{number2}")
    @ResponseBody
    public String subtractNumbers(@PathVariable int number1, @PathVariable int number2) {
        return ("The difference is: " + (number2 - number1));
    }

    @GetMapping("/multiply/{number1}/and/{number2}")
    @ResponseBody
    public String multiplyNumbers(@PathVariable int number1, @PathVariable int number2) {
        return ("The product is: " + (number1 * number2));
    }

    @GetMapping("/divide/{number1}/by/{number2}")
    @ResponseBody
    public String divideNumbers(@PathVariable int number1, @PathVariable int number2) {
        return ("The quotient is: " + (number1 / number2));
    }
}
