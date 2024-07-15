package com.projectImage.Image_Gallery.controller;

import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;

@RestController
@RequestMapping("/api/v1") 
public class ImageController {

    @Autowired
    ImageServices imageService;

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/images/{id}")
    public Image getImageById(@PathVariable Long id) throws InstanceNotFoundException {
        return imageService.getImageById(id);
    }

    @PostMapping (path = "images")
    public Image createImage(@RequestBody Image newImage) {
        return imageService.createImage(newImage);
    }

    @PutMapping("/images/{id}")
    public Image updateImage(@PathVariable Long id, @RequestBody Image updatedImage) throws InstanceNotFoundException {
        return imageService.updateImage(id, updatedImage);
    }

    @DeleteMapping("/images/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}
