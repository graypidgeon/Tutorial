package com.example.demo.service;

import com.example.demo.model.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface ImageService {
    Resource getResource(String imagePath) throws MalformedURLException;
    void replaceImage(Image oldImage, MultipartFile newImage, String newImageName) throws IOException;
    Image findById(Long id);


    public static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
