package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.models.Image;

import com.projectImage.Image_Gallery.repositories.IImageRepository;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    private IImageRepository iImageRepository;

    @InjectMocks
    ImageServices imageServices;

    @Test
    void test_Create_Image_Id() {
        Image image = new Image();
        when(iimageRepository.save(any(Image.class))).thenReturn(image);

    @BeforeEach

    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Image result = imageServices.createImage(image);

        assertNotNull(result);
        verify(iimageRepository, times(1)).save(any(Image.class));
    }

    @Test
    public void test_if_deleteImage_deletes_by_Id() {
        ArrayList<Image> listOfImages = new ArrayList<Image>();

        Image image1 = new Image(1L, "árbol", "picture of mountains, trees and a lake",
                "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/arbol.jpg?raw=true",
                false);
        Image image2 = new Image(2L,"hojas", "picture of green leaves, yellow and orange leaves",
                "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/hojas.jpg?raw=true",
                false);
        Image image3 = new Image(3L,"lago", "picture of mountains, trees and a lake in winter",
                "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/lago.jpg?raw=true",
                false);
        listOfImages.add(image1);
        listOfImages.add(image2);
        listOfImages.add(image3);
        when(iImageRepository.findAll()).thenReturn(listOfImages);

        imageServices.deleteImage(2L);

        verify(iImageRepository).deleteById(2L);

    }

    void test_Create_Image_Title() {
        Image image = new Image();
        image.setTitle("new Image");
        when(iimageRepository.save(any(Image.class))).thenReturn(image);

        Image result = imageServices.createImage(image);

        assertNotNull(result);
        verify(iimageRepository).save(any(Image.class));
    }

    @Test
    void test_Create_Image_Description() {
        Image image = new Image();
        image.setDescription("HTTP methods");
        when(iimageRepository.save(any(Image.class))).thenReturn(image);

        Image result = imageServices.createImage(image);

        assertNotNull(result);
        assertEquals(result.getDescription(), "HTTP methods");
        verify(iimageRepository).save(any(Image.class));
    }
}
