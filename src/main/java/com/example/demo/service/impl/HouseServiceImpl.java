package com.example.demo.service.impl;

import com.example.demo.model.*;
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
        return houseRepository.findAll(
                Specification.where(HouseSpecs.fetchMainImage()),
                Sort.by(order));
    }

    @Override
    public House findById(Long id) {
        return houseRepository.findOneWithImagesById(id);
    }

    @Override
    public List<House> findBySearchCriteria(HouseSearchCriteria hsc) {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, hsc.getOrderBy().getPropertyName()).ignoreCase();

        return houseRepository.findAll(
                Specification.where(HouseSpecs.nameLike(hsc.getName()))
                    .and(HouseSpecs.usageAreaBetween(hsc.getUsageAreaFrom(), hsc.getUsageAreaTo()))
                    .and(HouseSpecs.minWidthAndHeight(hsc.getMinWidth(), hsc.getMinHeight()))
                    .and(HouseSpecs.buildingAreaBetween(hsc.getBuildingAreaFrom(), hsc.getBuildingAreaTo()))
                    .and(HouseSpecs.storeyEquals(hsc.getStorey()))
                    .and(HouseSpecs.garageEquals(hsc.getGarage()))
                    .and(HouseSpecs.fetchMainImage()),
                Sort.by(order));
    }

    @Override
    @Transactional
    public void saveHouse(Long id, House stateFromForm, MultipartFile imageFile) throws IOException {
        House databaseState = findById(id);

        saveHouse(databaseState, stateFromForm, imageFile, databaseState.getMainImage());
    }

    @Override
    @Transactional
    public House addNewHouse(House stateFromForm, MultipartFile imageFile) throws IOException {
        return saveHouse(stateFromForm, stateFromForm, imageFile, null);
    }

    @Override
    public void deleteHouse(Long id) throws IOException {
        imageService.getResource(
            houseRepository.findOneWithImagesById(id).getMainImage().getImagePath()
        ).getFile().delete();
        houseRepository.deleteById(id);
    }

    private House saveHouse(House databaseState, House stateFromForm, MultipartFile imageFile, Image oldImage) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileExtension = ImageService.getFileExtension(imageFile.getOriginalFilename());
            if (databaseState.getMainImage() == null) {
                databaseState.getImages().add(new Image()
                        .withImageSection(ImageSection.MAIN));
            }
            databaseState.getMainImage().setImagePath(RandomStringUtils.randomAlphabetic(15)
                    + "." + fileExtension);
        }
        databaseState.updateFromForm(stateFromForm);
        House returnObject = houseRepository.save(databaseState);

        imageService.replaceImage(oldImage, imageFile, databaseState.getMainImage().getImagePath());
        //TODO delete old image

        return returnObject;
    }
}
