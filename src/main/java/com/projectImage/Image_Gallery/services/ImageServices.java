package com.projectImage.Image_Gallery.services;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageServices {

    @Autowired
    IimageRepository iimageRepository;

    //update
    public Image updateImage(Image image) {
        return (Image) iimageRepository.save(image);
    }

}
