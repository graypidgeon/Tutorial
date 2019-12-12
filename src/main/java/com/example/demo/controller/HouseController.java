package com.example.demo.controller;

import com.example.demo.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @GetMapping("/edit/{id}")
    public String editHouse(Model m, @PathVariable Long id) {
        m.addAttribute("house", houseRepository.findById(id));
        return "edit-house";
    }
}
