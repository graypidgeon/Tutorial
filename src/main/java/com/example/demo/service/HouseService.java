package com.example.demo.service;

import com.example.demo.model.House;
import com.example.demo.model.HouseSearchCriteria;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HouseService {
    List<House> findAll();
    House findById(Long id);
    List<House> findBySearchCriteria(HouseSearchCriteria hsc);

    void saveHouse(Long id, House stateFromForm, MultipartFile imageFile) throws IOException;
}
