package com.example.demo.controller;

import com.example.demo.model.HouseSearchCriteria;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("searchCriteria")
    public HouseSearchCriteria populateUser() {
        return new HouseSearchCriteria();
    }
}
