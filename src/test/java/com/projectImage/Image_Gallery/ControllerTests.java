package com.projectImage.Image_Gallery;


import com.projectImage.Image_Gallery.controller.ImageController;
import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jmx.export.annotation.ManagedOperation;

import java.util.ArrayList;

@SpringBootTest
public class ControllerTests {

    @Mock
    private ImageServices imageServices;

    @InjectMocks
    private ImageController imageController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Image image1 = new Image();
        image1.setId(1L);
        image1.setTitle("árbol");
        image1.setDescription("picture of mountains, trees and a lake");
        image1.setUrl("https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/arbol.jpg?raw=true");
        image1.setFavorite(false);

        Image image2 = new Image();
        image2.setId(2L);
        image2.setTitle("hojas");
        image2.setDescription("picture of green leaves, yellow and orange leaves");
        image2.setUrl("https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/hojas.jpg?raw=true");
        image2.setFavorite(false);

        Image image3 = new Image();
        image3.setTitle("lago");
        image3.setDescription("picture of mountains, trees and a lake in winter");
        image3.setUrl("https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/lago.jpg?raw=true");
        image3.setFavorite(false);

        ArrayList<Image> imageList = new ArrayList<Image>();
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
    }



}
