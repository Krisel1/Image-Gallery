package com.projectImage.Image_Gallery.controller;

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


}
