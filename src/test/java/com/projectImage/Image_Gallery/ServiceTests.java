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

import java.lang.reflect.Array;
import java.util.ArrayList;

@SpringBootTest
public class ServiceTests {

    @Mock
    private IimageRepository iimageRepository;

    @InjectMocks
    private ImageServices imageServices;

    @BeforeEach
    public setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_if_deleteImage_deletes_by_Id(){
        ArrayList<Image> listOfImages = new ArrayList<Image>();

        Image image1 = new Image ("árbol", "picture of mountains, trees and a lake", "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/arbol.jpg?raw=true", false);
        Image image2 = new Image ("hojas", "picture of green leaves, yellow and orange leaves", "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/hojas.jpg?raw=true", false);
        Image image3 = new Image ("lago", "picture of mountains, trees and a lake in winter", "https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/lago.jpg?raw=true", false);
        listOfImages.add(image1);
        listOfImages.add(image2);
        listOfImages.add(image3);
        when()

    }
}
