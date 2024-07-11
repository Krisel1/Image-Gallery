package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    private IimageRepository iimageRepository;

    @InjectMocks
    private ImageServices imageServices;

    @Test
    void test_Create_Image_Id() {
        Image image = new Image();
        when(iimageRepository.save(any(Image.class))).thenReturn(image);

        Image result = imageServices.createImage(image);

        assertNotNull(result);
        verify(iimageRepository, times(1)).save(any(Image.class));
    }

}
