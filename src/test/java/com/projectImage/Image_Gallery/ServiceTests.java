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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class ServiceTests {

    @Mock
    private IimageRepository iimageRepository;

    @InjectMocks
    private ImageServices imageServices;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test_Create_Image_Id() {
        Image image = new Image();
        when(imageServices.createImage(any(Image.class))).thenReturn(new Image());

        Image result = imageServices.createImage(new Image());

        assertNotNull(result);
        verify(imageServices, times(1)).createImage(any(Image.class));
    }

    @Test
    public void test_if_createTutorial_creates_Id() {
        //Arrange
        Image image = new Image();
        new Image.setId(1L);
        when(iimageRepository.save(any(Image.class))).thenReturn(new Image);

        //Act
        Image result = imageServices.createImage(new Image);

        //Assert
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(iimageRepository).save(new Image);
    }

//    @Test
//    public void test_if_createTutorial_creates_title() {
//        //Arrange
//        Tutorial newTutorial = new Tutorial();
//        newTutorial.setTitle("New Tutorial");

//        when(iTutorialRepository.save(any(Tutorial.class))).thenReturn(newTutorial);

//        //Act
//        Tutorial result = tutorialServices.createTutorial(newTutorial);

//        //Assert
//        assertNotNull(result);
//        assertEquals("New Tutorial", result.getTitle());
//        verify(iTutorialRepository).save(newTutorial);
//    }

//    @Test
//    public void test_if_createTutorial_creates_description() {
//        //Arrange
//        Tutorial newTutorial = new Tutorial();
//        newTutorial.setDescription("Here goes a detailed description of tutorial");
//
//        when(iTutorialRepository.save(any(Tutorial.class))).thenReturn(newTutorial);

//        //Act
//        Tutorial result = tutorialServices.createTutorial(newTutorial);

//        //Assert
//        assertNotNull(result);
//        assertEquals("Here goes a detailed description of tutorial", result.getDescription());
//        verify(iTutorialRepository).save(newTutorial);
//    }

}
