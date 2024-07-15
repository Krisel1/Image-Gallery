package com.projectImage.Image_Gallery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.projectImage.Image_Gallery.models.Image;

public interface IImageRepository extends CrudRepository<Image, Long> {
}