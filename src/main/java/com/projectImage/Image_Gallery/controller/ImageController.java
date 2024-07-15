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
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ImageController {


    @Autowired
    ImageServices imageServices;

    @GetMapping("/images")
    public List<Image> getAllImages() {
        return imageServices.getAllImages();
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id) throws InstanceNotFoundException {
        return imageServices.getImageById(id);
    }

    @PostMapping(path = "images")
    public Image createImage(@RequestBody Image newImage) {
        return imageServices.createImage(newImage);
    }

    @DeleteMapping(path = "/images/{id}")
    public void deleteImage(@PathVariable long id) {
        imageServices.deleteImage(id);
    }

    @PutMapping(path = "/images/{id}")
    public void updateImage(@RequestBody Image image, @PathVariable Long id){
        imageServices.updateImage(id, image);
    }
}
