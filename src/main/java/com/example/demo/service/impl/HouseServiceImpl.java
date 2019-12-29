package com.example.demo.service.impl;

import com.example.demo.model.House;
import com.example.demo.model.HouseSearchCriteria;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.HouseSpecs;
import com.example.demo.service.HouseService;
import com.example.demo.service.ImageService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private ImageService imageService;

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public House findById(Long id) {
        return houseRepository.findById(id).get();
    }

    @Override
    public List<House> findBySearchCriteria(HouseSearchCriteria hsc) {
        Specification spec1 = HouseSpecs.nameLike(hsc.getName());
        Specification spec2 = HouseSpecs.descriptionLike(hsc.getDescription());

        return houseRepository.findAll(Specification.where(spec1).and(spec2));
    }

    @Override
    @Transactional
    public void saveHouse(Long id, House stateFromForm, MultipartFile imageFile) throws IOException {
        House databaseState = findById(id);

        saveHouse(databaseState, stateFromForm, imageFile, databaseState.getImagePath());
    }

    @Override
    @Transactional
    public House addNewHouse(House stateFromForm, MultipartFile imageFile) throws IOException {
        return saveHouse(stateFromForm, stateFromForm, imageFile, null);
    }

    private House saveHouse(House databaseState, House stateFromForm, MultipartFile imageFile, String oldImagePath) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileExtension = ImageService.getFileExtension(imageFile.getOriginalFilename());
            databaseState.setImagePath(RandomStringUtils.randomAlphabetic(15)
                    + "." + fileExtension);
        }
        databaseState.updateFromForm(stateFromForm);
        House returnObject = houseRepository.save(databaseState);

        imageService.replaceImage(oldImagePath, imageFile, databaseState.getImagePath());

        return returnObject;
    }
}
