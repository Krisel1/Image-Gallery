package com.projectImage.Image_Gallery.controller;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ImageController {
    String API_BASE_URL = "http://localhost:8080/api/v1";
    ImageServices imageService;

    @DeleteMapping(path = "/{API_BASE_URL}{id}")
    public void deleteImage(@PathVariable long id, @RequestBody Image image) {
        imageService.deleteImage(id);
    }

}
