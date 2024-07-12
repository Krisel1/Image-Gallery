package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.controller.ImageController;
import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceTests {

    @Mock
    private IimageRepository iimageRepository;

    @InjectMocks
    private ImageServices imageServices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUpdateImage() {
        // Arrange
        Long id = 1L;
        Image newImage = new Image();
        newImage.setTitle("Test Image");

        // Act
        imageServices.updateImage(id, newImage);

        // Assert
        verify(iimageRepository).save(any(Image.class));
        assert(newImage.getId().equals(id));
    }

//    @Test
//    public void testUpdateImageFavorite() {
//        // Arrange
//        Long id = 1L;
//
//        // Act
//        imageServices.tagImageAsFavorite(id);
//
//        // Assert
//        verify(iimageRepository).save(any(Image.class));
//        assert(newImage.getId().equals(id));
//    }
}