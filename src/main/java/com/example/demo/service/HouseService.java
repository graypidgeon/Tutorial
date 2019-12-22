package com.example.demo.service;

import com.example.demo.model.House;
import com.example.demo.model.HouseSearchCriteria;

import java.util.List;

public interface HouseService {
    List<House> findAll();
    House findById(Long id);
    List<House> findBySearchCriteria(HouseSearchCriteria hsc);

    void editHouse(House house);
}
