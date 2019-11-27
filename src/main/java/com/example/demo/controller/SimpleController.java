package com.example.demo.controller;

import com.example.demo.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private HouseRepository repository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("houses", repository.findAll());
        return "home";
    }

    @GetMapping("/edit-house/{id}")
    public String editHouse(Model m, @PathVariable Long id) {
        m.addAttribute("house", repository.findById(id));
        return "edit-house";
    }
}