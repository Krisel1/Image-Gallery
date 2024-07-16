# Image Gallery Project

## Project Context:
A client has requested the creation of an image management system to store their favorite images. This system will allow users to upload and view images, add images to favorites, edit an image (e.g., the title), or delete it. To achieve this, we will use object-oriented programming concepts such as classes, objects, encapsulation, and inheritance in Java.

Competency Framework:
-

### Project Description:
The objective of this project is to develop an image management system in Java that allows users to:
- View a list of images (image and title)
- Add images to the database
- Delete images from the database
- Edit an existing image
- Add images to favorites

## Overview

This project is a RESTful web service for an image gallery, built using Spring Boot, MySQL, JPA, and Spring Web. It allows users to perform CRUD operations on images and tag images as favorites. Postman was used for testing the API endpoints, and the application follows the MVC architectural pattern.

## Table of Contents

- [Overview](#overview)
- [Dependencies](#dependencies)
- [Installation](#installation)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)


## Dependencies

The project uses the following dependencies:

- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL Connector
- Lombok
- JUnit 5
- Mockito

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/image-gallery.git
    cd image-gallery
    ```

2. Set up the MySQL database:
    ```sql
    CREATE DATABASE db_imagegallery;
    ```

3. Update the `application.properties` file with your MySQL credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/db_imagegallery
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Build and run the application:
    ```bash
    ./mvnw spring-boot:run
    ```


## Configuration

The `application.properties` file contains the configuration for the database connection and server settings:
```properties
spring.application.name=Image-Gallery
spring.datasource.url=jdbc:mysql://localhost:3306/db_imagegallery
spring.datasource.username=root
spring.datasource.password=
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
spring.jpa.hibernate.ddl-auto=update
```
## API Endpoints
The API provides the following endpoints for managing images:
### Get All Images
```GET /api/v1/images```
Response: A list of all images.
### Get Image by ID
```GET /api/v1/images/{id}```
Response: The image with the specified ID.
### Create a New Image
```POST /api/v1/images```
Request Body: JSON representation of the new image.
### Update an Image
```PUT /api/v1/images/{id}```
Request Body: JSON representation of the updated image.
### Delete an Image
```DELETE /api/v1/images/{id}```
### Tag an Image as Favorite
```PUT /api/v1/images/{id}```
## Testing
Unit tests are written using JUnit 5 and Mockito. The tests cover the controller, service, and model layers.
