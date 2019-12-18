package com.example.demo.service.impl;

import com.example.demo.model.House;
import com.example.demo.model.HouseSearchCriteria;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.HouseSpecs;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public List<House> findBySearchCriteria(HouseSearchCriteria hsc) {
        Specification spec1 = HouseSpecs.nameLike(hsc.getName());
        Specification spec2 = HouseSpecs.descriptionLike(hsc.getDescription());

        return houseRepository.findAll(Specification.where(spec1).and(spec2));
    }
}
