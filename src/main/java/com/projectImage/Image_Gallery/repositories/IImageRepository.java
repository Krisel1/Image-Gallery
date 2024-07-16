package com.projectImage.Image_Gallery.repositories;

import com.projectImage.Image_Gallery.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface IImageRepository extends CrudRepository<Image, Long> {
}
