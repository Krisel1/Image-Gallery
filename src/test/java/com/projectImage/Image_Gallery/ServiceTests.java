package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.repositories.IimageRepository;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void test_if_updateImage() {

    }

}
