package com.nextstep.docker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "docker prac", version = "v1", description = "application docker compose"))
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
