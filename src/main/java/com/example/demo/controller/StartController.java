package com.example.demo.controller;

import com.example.demo.model.HouseOrderBy;
import com.example.demo.model.HouseSearchCriteria;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StartController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HouseService houseService;

    @GetMapping(value = {"/", "/loginAction"})
    public String homePage(Model model) {
        HouseOrderBy orderBy = HouseOrderBy.NAME;
        model.addAttribute("houses", houseService.findAll(orderBy));
        return "home";
    }

    @PostMapping("/search")
    //validation of sc
    public String search(Model model, @ModelAttribute HouseSearchCriteria sc) {
        model.addAttribute("houses", houseService.findBySearchCriteria(sc));
        model.addAttribute("searchCriteria", sc);
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