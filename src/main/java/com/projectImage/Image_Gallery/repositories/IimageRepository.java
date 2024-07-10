package com.projectImage.Image_Gallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectImage.Image_Gallery.models.Image;

public interface IimageRepository extends  JpaRepository<Image, Long>{
}
