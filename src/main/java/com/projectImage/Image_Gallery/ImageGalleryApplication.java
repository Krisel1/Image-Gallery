package com.projectImage.Image_Gallery;

import com.projectImage.Image_Gallery.services.ImageServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImageGalleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageGalleryApplication.class, args);
	}

}
