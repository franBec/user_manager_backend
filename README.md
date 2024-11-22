# user_manager_backend

## Project Overview
This project is implemented in **Java Spring Boot 3** and provides a RESTful API for querying a users' database.

- Is a demonstration of how to consume and create an API following [Design by Contract principles](https://en.wikipedia.org/wiki/Design_by_contract).
- You can read more about the creation of this repo in my [Spring Boot Development](https://pollito.dev/en/categories/spring-boot-development/) blog series.

## Branch Overview

- In the main branch, users are obtained from a mocked database.
- In the feature/feignClient branch, users are obtained from an external API.

![branch-overview](/assets/images/Untitled-2024-11-22-2023.jpg)

## API Documentation
The OpenAPI documentation for the API can be found in the [src/main/resources/openapi/userManagerBackend.yaml file](https://github.com/franBec/user_manager_backend/blob/main/src/main/resources/openapi/userManagerBackend.yaml).

## Live Demo
`https://user-manager-backend-den3.onrender.com`

It is hosted on a [render](https://dashboard.render.com/) free instance.
- free instances will spin down with inactivity, which can delay requests of some minutes.

## Getting Started

### Prerequisites
- For running with Maven:
  - **Java 21**
  - **Maven**
- For containerized deployment 
  - **Docker**

### Run with Maven
1. Clone the repository:
    ```bash
    git clone https://github.com/franBec/user_manager_backend
    ```
2. Navigate to the project directory:
    ```bash
    cd user_manager_backend
    ```
3. Build and run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```
### Run with Maven
1. Clone the repository:
     ```bash
     git clone https://github.com/franBec/user_manager_backend
     ```
2. Navigate to the project directory:
    ```bash
    cd user_manager_backend
    ```
3. Build the Docker image:
    ```bash
    docker build -t user_manager_backend .
    ```
4. Run the Docker container:
     ```bash
     docker run -p 8080:8080 user_manager_backend
     ```

## Author
Franco Exequiel Becvort <🐤/>
- [Linkedin](https://www.linkedin.com/in/franco-becvort/)
- [Website](https://pollito.dev/)

This project is intended for educational purposes.
