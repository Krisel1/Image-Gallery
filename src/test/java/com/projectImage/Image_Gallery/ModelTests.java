package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.models.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTests {

    @Test
    public void testId() {

        Image image = new Image();
        Long id = 3L;
        image.setId(id);
        assertEquals(id, image.getId());
    }

    @Test
    public void tesTitle() {

        Image tutorial = new Image();
        String title = "Java";
        tutorial.setTitle(title);
        assertEquals(title, tutorial.getTitle());
    }

    @Test
    public void testDescription() {

        Image tutorial = new Image();
        String description = "HTTP methods";
        tutorial.setDescription(description);
        assertEquals(description, tutorial.getDescription());
    }

}
