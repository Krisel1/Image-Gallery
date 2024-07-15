package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IImageRepository;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


import java.security.cert.Extension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ServiceTests {

    @Mock
    private IImageRepository iImageRepository;

    @InjectMocks
    private ImageServices imageServices;
    private Image image;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        image = new Image();
        image.setId(1L);
        image.setFavorite(false);
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
        verify(iImageRepository).save(any(Image.class));
        assert(newImage.getId().equals(id));
    }

    @Test
    void testTagImageAsFavorite() {
        // Arrange
        when(iImageRepository.findById(1L)).thenReturn(Optional.of(image));

        // Act
        imageServices.tagImageAsFavorite(1L);

        // Assert
        verify(iImageRepository).findById(1L);
        verify(iImageRepository).save(image);
        assert(image.isFavorite());
    }

    @Test
    void testTagImageAsFavorite_ImageNotFound() {
        // Arrange
        when(iImageRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        imageServices.tagImageAsFavorite(1L);

        // Assert
        verify(iImageRepository).findById(1L);
        verify(iImageRepository).save(any(Image.class)); // This line should fail as save should not be called
    }
}