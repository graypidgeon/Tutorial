package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StartController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HouseRepository houseRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("houses", houseRepository.findAll());
        return "home";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "register";
    }

    @PostMapping("/signup")
    public String register(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup";
        }

        //TODO nadanie roli
        userRepository.save(user);
        return "redirect:/";
    }
}