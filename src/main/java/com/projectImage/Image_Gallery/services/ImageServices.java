package com.projectImage.Image_Gallery.services;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageServices {

    @Autowired
    IimageRepository iimageRepository;

    public Image createImage(Image newImage){
        return iimageRepository.save(newImage);
    }

    public void createAndSaveImages() {
        Image img1 = new Image();
        img1.setTitle("Sunset");
        img1.setDescription("A beautiful sunset over the mountains.");
        img1.setUrl("http://example.com/sunset.jpg");
        img1.setFavorite(true);
        createImage(img1);

        Image img2 = new Image();
        img2.setTitle("Ocean");
        img2.setDescription("A tranquil ocean scene.");
        img2.setUrl("http://example.com/ocean.jpg");
        img2.setFavorite(false);
        createImage(img2);

        iimageRepository.save(img1);
        iimageRepository.save(img2);
    }
}
