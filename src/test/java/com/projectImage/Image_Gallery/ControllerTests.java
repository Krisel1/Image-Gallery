package com.projectImage.Image_Gallery;


import com.projectImage.Image_Gallery.controller.ImageController;
import com.projectImage.Image_Gallery.models.Image;
import com.projectImage.Image_Gallery.services.ImageServices;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ControllerTests {

    @Mock
    private ImageServices imageServices;

    @InjectMocks
    private ImageController imageController;
    private MockMvc mockMvc;

    private Image image1;
    private Image image2;
    private Image image3;
    private ArrayList<Image> imageList;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();

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
        image3.setId(3L);
        image3.setTitle("lago");
        image3.setDescription("picture of mountains, trees and a lake in winter");
        image3.setUrl("https://github.com/diegoFactoriaf5/MyFavoriteImage-Frontend/blob/main/src/assets/images/lago.jpg?raw=true");
        image3.setFavorite(false);

        imageList = new ArrayList<>();
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
    }

    @Test
    public void testUpdateImage() throws Exception {
        Long id = 1L;
        Image testImage = new Image();
        testImage.setName("Test Image");

        doNothing().when(imageServices).updateImage(eq(id), any(Image.class));

        mockMvc.perform(put("/api/images/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testImage)))
                .andExpect(status().isOk());
    }

    @Test
    public void test_if_deleteImage_deletes_by_Id() {
        when(imageServices.getAllImages()).thenReturn(imageList);

        //Act
        imageController.deleteImage(2L);

        //Assert
        verify(imageServices).deleteImage(2L);

    }

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
        Image image = new Image();
        image.setDescription("HTTP methods");
        when(imageServices.createImage(any(Image.class))).thenReturn(image);

        Image result = imageController.createImage(image);

        assertNotNull(result);
        assertEquals(result.getDescription(), "HTTP methods");
        verify(imageServices, times(1)).createImage(any(Image.class));
    }

    @Test
    public void test_GetAllImage(){
        when(imageServices.getAllImages()).thenReturn(imageList);

        List<Image> result = imageController.getAllImages();

        assertNotNull(result);
        assertEquals(result.size(), 3);
        verify(imageServices, times(1)).getAllImages();

    }

    @Test
    public void test_GetImageById() throws Exception {
    Long id = 1L;
    Image image = new Image();
    image.setId(id);
    when(imageServices.getImageById(id)).thenReturn(image);

    Image result = imageController.get(id);

    assertNotNull(result);
    assertEquals(result.getId(), id);
    verify(imageServices, times(1)).getImageById(id);
}


}