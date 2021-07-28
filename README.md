# Introduction

This is a boilerplate project that i made for speed up developing process of a backend application with Spring and MySQL,
other tecnologies and libraries are used in this project, i will detail further in next topics.
All configurations issues are resolved, only clone and code, in next steps i will explain how to do this.
The boilerplate project contains some sample classes, like Models, Repositories, Services and others. 
Feel free to delete those and code your own classes.

# Pre requisites

Docker and Docker Compose, if you don't have these tools, please go to official site of Docker and see how to install.

# Tecnologies

- Spring Ecosystem (Spring Data, Spring Boot and others)
- MySQL Database
- Docker
- Testcontainers
- JUnit4
- Swagger
- Env file
- Lombok
- Validation API

# How to run

- After installing Docker and Docker Compose, you need to set the environment variables (or use predefined ones), the root folder has
a .env file, here you can set your own values to environment variables.

- After setting up your environment variables, is really simple to run the project. Open your terminal go to the root folder and run the following command:
  - docker-compose up --build (if you want to run in detached mode, add this argument -d)

- The first time will be a bit slow to start up, because docker will download the necessary images for create the container and after this the script in Dockerfile
will download all Maven dependencies for the project.

# Useful info

## Testing

### Testcontainers

- Testcontainers is a library to provide built in Docker containers, this a powerful lib which helps a lot in Integration Tests. The project contains base classes
that i used to create some sample Test cases.

### JUnit4

- I combined Testcontainers, JUnit4, MockMVC for creating sample Unit (Only JUnit4)  and Integration test cases for help people learn more about testing.
Will you find some base test classes and upon then, you can develop own Test cases

## Documentation

### Swagger

- I used Swagger to doc my project, like testing, you will find some sample documented Controller classes and take this as base for documente your own endpoints.

- When application is up, this link will be available to see Docs. [Swagger](http://localhost:8080/swagger-ui-custom.html)

## Environment variables

- I created a .env file to save my environment variables and use in docker-compose, feel free to add this file in .gitignore and hide your variables if you want
to commit your application somewhere

## Lombok

- Lombok is a lib to decrease code repeat, you will find annotations in Model and DTOs classes, like @Data, @AllArgsBuilder and others. This reduce code repeat and
improve clean code.

## Validation API

- Is a Java lib to provides Validations upon a request for example, you can annotate a field of your DTO with @NotBlank,
if your endpoint receives a Request Body with a empty string in this field, then the application will throw an error.

