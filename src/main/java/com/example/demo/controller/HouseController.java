package com.example.demo.controller;

import com.example.demo.model.House;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/get/{id}")
    public String viewHouse(Model model, @PathVariable("id") Long id) {
        model.addAttribute("house", houseService.findById(id));

        return "view-house";
    }

    @GetMapping("/add")
    public String addHouse(Model m) {
        m.addAttribute("house", new House());
        return "add-house";
    }

    @PostMapping("/add")
    public String addHouse(Model model, @Valid House house, @RequestParam MultipartFile imageFile,
            BindingResult result) throws IOException {
        model.addAttribute("house", houseService.addNewHouse(house, imageFile));
        return "edit-house";
    }

    @GetMapping("/delete/{id}")
    public String addHouse(Model m, @PathVariable Long id) throws IOException {
        houseService.deleteHouse(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editHouse(Model m, @PathVariable Long id) {
        m.addAttribute("house", houseService.findById(id));
        return "edit-house";
    }

    @PostMapping("/edit/{id}")
    public String editHouse(Model model, @PathVariable("id") Long id,
            @Valid House house, @RequestParam MultipartFile imageFile, BindingResult result)
            throws IOException {
        if (!result.hasErrors()) {
            houseService.saveHouse(id, house, imageFile);
        }

        return editHouse(model, id);
    }
}
