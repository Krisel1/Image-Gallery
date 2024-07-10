package com.projectImage.Image_Gallery.services;

import com.projectImage.Image_Gallery.repositories.IimageRepository;

public class ImageServices {
    IimageRepository iimageRepository;
    public void deleteImage(long id) {
        iimageRepository.deleteById(id);
    }
}
