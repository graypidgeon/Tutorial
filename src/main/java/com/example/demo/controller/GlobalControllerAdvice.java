package com.example.demo.controller;

import com.example.demo.model.SearchCriteria;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("searchCriteria")
    public SearchCriteria populateUser() {
        return new SearchCriteria();
    }
}
