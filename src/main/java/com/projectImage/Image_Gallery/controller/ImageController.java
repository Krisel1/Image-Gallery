package com.projectImage.Image_Gallery.controller;

import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ImageController {


    @Autowired
    ImageServices imageService;

    @GetMapping("")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/images/{id}")
    public Image get(@PathVariable Long id) throws InstanceNotFoundException{
        return imageService.getImageById(id);
    }

    @PostMapping(path = "/images")
    public Image createImage(@RequestBody Image newImage) {
        return imageService.createImage(newImage);
    }

    @DeleteMapping(path = "/images/{id}")
    public void deleteImage(@PathVariable long id) {
        imageService.deleteImage(id);
    }

    @PutMapping(path = "/images/{id}")
    public void updateImage(@RequestBody Image image, @PathVariable Long id){
        imageService.updateImage(id, image);
    }
}
