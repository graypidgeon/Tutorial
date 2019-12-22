package com.example.demo.controller;

import com.example.demo.model.House;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/edit/{id}")
    public String editHouse(Model m, @PathVariable Long id) {
        m.addAttribute("house", houseService.findById(id));
        return "edit-house";
    }

    @PostMapping("/edit/{id}")
    public String editHouse(Model model, @PathVariable("id") Long id,
                            @Valid House house, BindingResult result) {
        house.setId(id);
        if (!result.hasErrors()) {
            houseService.editHouse(house);
        }

        return editHouse(model, id);
    }
}
