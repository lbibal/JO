package com.example.jo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class JoApplication {

    private static final Logger logger = LoggerFactory.getLogger(JoApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(JoApplication.class, args);
        logger.info("Server started at: localhost:8080");
        logger.info("Documentation can be found at: localhost:8080/swagger-ui.html");
    }
}
