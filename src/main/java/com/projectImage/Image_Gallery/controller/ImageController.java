package com.projectImage.Image_Gallery.controller;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;

import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ImageController {


    @Autowired
    ImageServices imageService;

    @GetMapping("/images")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public Image get(@PathVariable Long id) throws InstanceNotFoundException{
        return imageService.getImageById(id);
    }
            
    @PostMapping(path = "images")
    public Image createImage(@RequestBody Image newImage) {
        return imageService.createImage(newImage);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteImage(@PathVariable long id) {
        imageService.deleteImage(id);
    }

}
