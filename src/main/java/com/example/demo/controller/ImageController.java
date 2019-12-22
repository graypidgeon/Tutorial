package com.example.demo.controller;

import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

@RestController
public class ImageController {

    @Autowired
    private HouseService houseService;
    @Value("${images.path}")
    private String imagesPath;
    @Autowired
    Environment env;

    @RequestMapping(value = "/getImage/{id}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("id") Long id) throws IOException {
        var imgFile = getResource(imagesPath + "/" + houseService.findById(id).getImagePath());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

    private Resource getResource(String path) throws MalformedURLException {
        if (Arrays.asList(env.getActiveProfiles()).contains("prod")) {
            return new FileUrlResource(path);
        } else {
            return new ClassPathResource(path);
        }
    }
}
