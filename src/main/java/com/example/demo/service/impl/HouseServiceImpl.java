package com.example.demo.service.impl;

import com.example.demo.model.House;
import com.example.demo.model.HouseOrderBy;
import com.example.demo.model.HouseSearchCriteria;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.HouseSpecs;
import com.example.demo.service.HouseService;
import com.example.demo.service.ImageService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public List<House> findAll(HouseOrderBy orderBy) {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, orderBy.getPropertyName()).ignoreCase();
        return houseRepository.findAll(Sort.by(order));
    }

    @Override
    public House findById(Long id) {
        return houseRepository.findById(id).get();
    }

    @Override
    public List<House> findBySearchCriteria(HouseSearchCriteria hsc) {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, hsc.getOrderBy().getPropertyName()).ignoreCase();
        Specification spec1 = HouseSpecs.nameLike(hsc.getName());
        Specification spec2 = HouseSpecs.descriptionLike(hsc.getDescription());
        Specification spec3 = HouseSpecs.areaBetween(hsc.getAreaFrom(), hsc.getAreaTo());

        return houseRepository.findAll(Specification.where(spec1).and(spec2).and(spec3), Sort.by(order));
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

    @Override
    @Transactional
    public void deleteHouse(Long id) throws IOException {
        imageService.getResource(
            houseRepository.findById(id).get().getImagePath()
        ).getFile().delete();
        houseRepository.deleteById(id);
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
