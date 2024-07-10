package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.repositories.IImageRepository;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTests {

    @Mock
    private IImageRepository iimageRepository;

    @InjectMocks
    private ImageServices imageServices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    //@Test
}
