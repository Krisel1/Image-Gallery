package com.projectImage.Image_Gallery.services;

<<<<<<< HEAD
import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IImageRepository;
=======

import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;
>>>>>>> origin/feature/read

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;


@Service
public class ImageServices {

    @Autowired
<<<<<<< HEAD
    IImageRepository iImageRepository;


    public void deleteImage(long id) {
        iImageRepository.deleteById(id);
    }

    public Image createImage(Image newImage){
        return iImageRepository.save(newImage);
=======
    IimageRepository IimageRepository;

    public List<Image> getAllImages(){
        return (List<Image>) IimageRepository.findAll();
    }

    public Image getImageById(Long id) throws InstanceNotFoundException {
        Optional<Image> image = IimageRepository.findById(id);
        return image.orElseThrow(() -> new InstanceNotFoundException("Image not found with id " + id));
>>>>>>> origin/feature/read
    }

}
