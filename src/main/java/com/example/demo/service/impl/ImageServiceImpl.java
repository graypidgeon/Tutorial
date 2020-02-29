package com.example.demo.service.impl;

import com.example.demo.model.Image;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ImageRepository imageRepository;

    public String getImagePath() {
        return imagesPath;
    }

    @Override
    public Resource getResource(String imagePath) throws MalformedURLException {
        String resourcePath = getImagePath() + imagePath;
        return new FileUrlResource(resourcePath);
    }

    @Override
    public void replaceImage(Image oldImage, MultipartFile newImage, String newImageName) throws IOException {
        if (!newImage.isEmpty()) {
            if (oldImage != null) {
                getResource(oldImage.getImagePath()).getFile().delete();
            }
            newImage.transferTo(new File(getImagePath() + newImageName).getAbsoluteFile());
        }
    }

    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).get();
    }
}
