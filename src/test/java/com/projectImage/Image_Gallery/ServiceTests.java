package com.projectImage.Image_Gallery;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IImageRepository;
import com.projectImage.Image_Gallery.services.ImageServices;

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
    public void test_if_deleteImage_deletes_by_Id() {
        ArrayList<Image> listOfImages = new ArrayList<>();

        Image image1 = new Image(1L, "árbol", "picture of mountains, trees and a lake",
                "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/arbol.jpg?raw=true",
                false);
        Image image2 = new Image(2L, "hojas", "picture of green leaves, yellow and orange leaves",
                "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/hojas.jpg?raw=true",
                false);
        Image image3 = new Image(3L, "lago", "picture of mountains, trees and a lake in winter",
                "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/lago.jpg?raw=true",
                false);
        listOfImages.add(image1);
        listOfImages.add(image2);
        listOfImages.add(image3);

        imageServices.deleteImage(2L);

        verify(iImageRepository).deleteById(2L);

    }

    @Test
    void test_Create_Image_Id() {
        Image image = new Image();
        when(iImageRepository.save(any(Image.class))).thenReturn(image);

        Image result = imageServices.createImage(image);

        assertNotNull(result);
        verify(iImageRepository, times(1)).save(any(Image.class));
    }

    @Test
    void test_Create_Image_Title() {
        Image image = new Image();
        image.setTitle("new Image");
        when(iImageRepository.save(any(Image.class))).thenReturn(image);

        Image result = imageServices.createImage(image);

        assertNotNull(result);
        verify(iImageRepository).save(any(Image.class));
    }

    @Test
    void test_Create_Image_Description() {
        Image image = new Image();
        image.setDescription("HTTP methods");
        when(iImageRepository.save(any(Image.class))).thenReturn(image);

        Image result = imageServices.createImage(image);

        assertNotNull(result);
        assertEquals(result.getDescription(), "HTTP methods");
        verify(iImageRepository).save(any(Image.class));
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
}