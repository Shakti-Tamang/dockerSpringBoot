package com.nextstep.docker.controller;

public class DockerImageContainerConcept {
//
//    What is Docker?
//    Docker is a platform for developing, shipping, and running applications in lightweight,
//    isolated environments called containers. It simplifies application deployment by packaging
//        code, dependencies, and configurations into a single unit, making it portable across
//    different environments.
//
//    Key Uses of Docker
//    Standardization: Ensures applications run consistently across development, testing, and
//    production environments.
//    Efficiency: Containers share the host OS kernel, making them lightweight compared to virtual
//    machines.
//    Scalability: Makes it easy to scale applications by running multiple container instances.
//            Portability: Runs on any platform that supports Docker, e.g., Linux, Windows, or cloud
//        providers.
//    Docker Components: Containers and Images
//1. Images
//    Definition: A Docker image is a lightweight, standalone, and immutable blueprint for creating containers.
//    What It Contains: The application code, runtime, libraries, environment variables, and configuration files.
//    Use: Images are used to create containers.
//    Example: A Spring Boot application image contains the app JAR, Java runtime, and dependencies.
//2. Containers
//    Definition: A container is a running instance of a Docker image.
//    What It Does: It runs the application and provides an isolated environment with all the dependencies from the image.
//    Use: Containers are used to execute applications.
//    Example: A container runs your Spring Boot app, making it accessible at a specific port.
//    Images vs. Containers
//    Feature	Image	Container
//    State	Static, read-only blueprint.	Dynamic, running instance of an image.
//    Purpose	Template to create containers.	Used to execute applications.
//    Mutability	Immutable (cannot be changed).	Mutable (can run, stop, and restart).
//    Storage	Stored in a registry (e.g., Docker Hub).	Runs in memory and disk while active.
//    Examples	openjdk:11, springboot-app:latest.	Running a Spring Boot app container.
//    Main Uses in Spring Boot
//    Containerization of Applications:
//
//    Package the Spring Boot application (JAR/WAR) into a Docker image.
//    Example: A Dockerfile to build a Spring Boot app image:
//    dockerfile
//    Copy code
//    FROM openjdk:11
//    COPY target/my-app.jar app.jar
//    ENTRYPOINT ["java", "-jar", "app.jar"]
//    Microservices Architecture:
//
//    Run each Spring Boot microservice in its own container.
//    Makes scaling and management easier.
//    Environment Isolation:
//
//    Run a Spring Boot app with dependencies (like MySQL, Redis) in separate containers.
//    Example: Use Docker Compose to define multiple services:
//    yaml
//    Copy code
//    version: '3.8'
//    services:
//    app:
//    build: .
//    ports:
//            - "8080:8080"
//    db:
//    image: mysql:8
//    environment:
//    MYSQL_ROOT_PASSWORD: password
//    Cloud Deployments:
//
//    Push Dockerized Spring Boot apps to platforms like AWS, Azure, or Kubernetes for deployment.
//    Why Use Docker with Spring Boot?
//    Consistency: Ensure the app works the same in dev, test, and prod environments.
//    Ease of Deployment: Simplifies the deployment process.
//    Isolation: Run multiple Spring Boot apps or services without conflicts.
//            Portability: Move the app seamlessly across platforms.
//    In summary, Docker simplifies the process of building, testing, and deploying Spring Boot applications while ensuring portability and scalability.

}
