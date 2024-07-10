package com.projectImage.Image_Gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ImageController {


    @Autowired
    private ImageServices imageService;

    @GetMapping("/images")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public Image get(@PathVariable Long id){
        return imageService.getImageById(id);
    }
            


}
