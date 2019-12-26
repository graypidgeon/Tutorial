package com.example.demo.service.impl;

import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${images.path}")
    private String imagesPath;

    public String getImagePath() {
        return imagesPath;
    }

    @Override
    public Resource getResource(String path) throws MalformedURLException {
        String resourcePath = getImagePath() + path;
        return new FileUrlResource(resourcePath);
    }

    @Override
    public void replaceImage(String oldImage, MultipartFile newImage, String newImageName) throws IOException {
        if (!newImage.isEmpty()) {
            getResource(oldImage).getFile().delete();
            newImage.transferTo(new File(getImagePath() + newImageName).getAbsoluteFile());
        }
    }
}
