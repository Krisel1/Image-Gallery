package com.projectImage.Image_Gallery.services;

import com.projectImage.Image_Gallery.repositories.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageServices {

    @Autowired
    IImageRepository iImageRepository;


    public String deleteImage(Long id) {
        try{
            iImageRepository.deleteById(id);
            return "The image"+ id + "has been deleted correctly.";
        }catch (Exception ignored){
            return "That image does not exist.";
        }
    }
}
