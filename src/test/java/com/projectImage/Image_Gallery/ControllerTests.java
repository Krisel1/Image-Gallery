package com.projectImage.Image_Gallery;


import com.projectImage.Image_Gallery.controller.ImageController;
import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTests {

    @Mock
    private ImageServices imageServices;

    @InjectMocks
    private ImageController imageController;

    @Test
    void test_Create_Image_Id() {
        Image image = new Image();
        image.setId(1L);
        when(imageServices.createImage(any(Image.class))).thenReturn(image);

        Image result = imageController.createImage(image);

        assertNotNull(result);
        assertEquals(result.getId(), 1L);
        verify(imageServices, times(1)).createImage(any(Image.class));
    }

    @Test
    public void test_Create_Image_title() {
        Image image = new Image();
        image.setTitle("New Image");
        when(imageServices.createImage(any(Image.class))).thenReturn(image);

        Image result = imageController.createImage(image);

        assertNotNull(result);
        assertEquals(result.getTitle(), "New Image");
        verify(imageServices, times(1)).createImage(any(Image.class));
    }

    @Test
    public void test_Create_Image_Description() {
        Image newImage = new Image();
        newImage.setDescription("HTTP methods");
        when(imageServices.createImage(any(Image.class))).thenReturn(newImage);

        Image result = imageController.createImage(newImage);

        assertNotNull(result);
        assertEquals(result.getDescription(), "HTTP methods");
        verify(imageServices, times(1)).createImage(any(Image.class));
    }
}