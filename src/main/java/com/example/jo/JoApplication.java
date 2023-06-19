package com.example.jo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class JoApplication {


    public static void main(String[] args) {

        SpringApplication.run(JoApplication.class, args);
    }

    @GetMapping("/")
    public List<String> bonjour(){
        return List.of("Bonjour", "pas","de","pblm ");
    }

}
