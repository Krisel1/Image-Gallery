package com.projectImage.Image_Gallery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;


@Service
public class ImageServices {

    @Autowired
    IimageRepository IimageRepository;

    public List<Image> getAllImages(){
        return IimageRepository.findAll();
    }

    public Image getImageById(@PathVariable Long id) {
        return IimageRepository.findById(id).orElse(null);
    }



}
