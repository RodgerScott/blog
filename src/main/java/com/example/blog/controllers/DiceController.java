package com.example.blog.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiceController {


    boolean correct;

    @GetMapping("roll-dice")
    public String mainPage() {
        return "dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String returnNumber(@PathVariable int number, Model model) {
        int randomNumber = (int) Math.ceil(Math.random() * 6);
        int counter = 0;

        model.addAttribute("number", number);
        model.addAttribute("randomNumber", randomNumber);

        if (number == randomNumber) {
            correct = true;
        } else {
            correct = false;
        }

        model.addAttribute("correct", correct);

        List<Integer> randomSeries = new ArrayList<>();
        randomSeries.add((int) Math.ceil(Math.random() * 6));
        randomSeries.add((int) Math.ceil(Math.random() * 6));
        randomSeries.add((int) Math.ceil(Math.random() * 6));
        randomSeries.add((int) Math.ceil(Math.random() * 6));
        randomSeries.add((int) Math.ceil(Math.random() * 6));
        randomSeries.add((int) Math.ceil(Math.random() * 6));
        randomSeries.add((int) Math.ceil(Math.random() * 6));

        for (int rando : randomSeries
             ) {
            if (number == rando) {
                counter += 1;
            }
        }
        model.addAttribute("randomSeries", randomSeries);

        model.addAttribute("counter", counter);

        return "dice";
    }

}
