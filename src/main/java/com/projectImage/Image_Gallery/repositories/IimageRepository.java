package com.projectImage.Image_Gallery.repositories;

import org.springframework.data.repository.CrudRepository;

import com.projectImage.Image_Gallery.models.Image;

public interface IimageRepository extends  CrudRepository<Image, Long>{
}
