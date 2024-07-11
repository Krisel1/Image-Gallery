package com.projectImage.Image_Gallery.services;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;
import com.projectImage.Image_Gallery.repositories.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageServices {

    @Autowired
    IImageRepository iImageRepository;


    public void deleteImage(long id) {

        iImageRepository.deleteById(id);
    }

    public Image createImage(Image newImage){
        return iimageRepository.save(newImage);
    }

}
