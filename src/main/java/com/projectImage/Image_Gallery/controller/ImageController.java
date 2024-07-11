package com.projectImage.Image_Gallery.controller;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ImageController {

    @Autowired
    ImageServices imageService;

    @PutMapping(path = "/images/{id}")
    public void updateImage(@RequestBody Image image, @PathVariable Long id){
        imageService.updateImage(id, image);
    }
}
