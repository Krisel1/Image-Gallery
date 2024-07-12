package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    IimageRepository iimageRepository;

    @InjectMocks
    ImageServices imageServices;

    @Test
    void test_Create_Image_Id() {
        Image image = new Image();
        when(iimageRepository.save(any(Image.class))).thenReturn(image);

        Image result = imageServices.createImage(image);

        assertNotNull(result);
        verify(iimageRepository, times(1)).save(any(Image.class));
    }

    @Test
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

    @Test
    public void test_Create_Images() {
        imageServices.createAndSaveImages();

        List<Image> images = iimageRepository.findAll();
        assertThat(images).hasSize(2);

        Image img1 = images.get(1);
        assertThat(img1.getTitle()).isEqualTo("Sunset");
        assertThat(img1.getDescription()).isEqualTo("A beautiful sunset over the mountains.");
        assertThat(img1.getUrl()).isEqualTo("http://example.com/sunset.jpg");
        assertThat(img1.isFavorite()).isTrue();

        Image img2 = images.get(2);
        assertThat(img2.getTitle()).isEqualTo("Ocean");
        assertThat(img2.getDescription()).isEqualTo("A tranquil ocean scene.");
        assertThat(img2.getUrl()).isEqualTo("http://example.com/ocean.jpg");
        assertThat(img2.isFavorite()).isFalse();

    }
}
