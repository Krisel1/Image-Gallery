package com.projectImage.Image_Gallery.services;

import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IImageRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return iImageRepository.save(newImage);
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
    public List<Image> getAllImages(){
        return (List<Image>) iImageRepository.findAll();
    }

    public Image getImageById(Long id) throws InstanceNotFoundException {
        Optional<Image> image = iImageRepository.findById(id);
        return image.orElseThrow(() -> new InstanceNotFoundException("Image not found with id " + id));
    }

    //update
    public void updateImage(Long id, Image newImage) {
        newImage.setId(id);
        iImageRepository.save(newImage);
    }
//    public void tagImageAsFavorite(Long id) {
//        Optional<Image> imageOptional = iImageRepository.findById(id);
//        if (imageOptional.isPresent()) {
//            Image image = imageOptional.get();
//            image.setFavorite(true);
//            iImageRepository.save(image);
//        } else {
//            throw new EntityNotFoundException("Image not found with id: " + id);
//        }
//    }
}

