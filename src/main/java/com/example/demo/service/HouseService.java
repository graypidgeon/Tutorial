package com.example.demo.service;

import com.example.demo.model.House;
import com.example.demo.model.HouseSearchCriteria;

import java.util.List;

public interface HouseService {
    List<House> findAll();
    List<House> findBySearchCriteria(HouseSearchCriteria hsc);
}
