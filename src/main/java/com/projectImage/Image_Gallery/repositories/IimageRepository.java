package com.projectImage.Image_Gallery.repositories;

import com.projectImage.Image_Gallery.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface IImageRepository extends CrudRepository<Image, Long> {
}
