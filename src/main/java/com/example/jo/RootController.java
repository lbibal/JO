package com.example.jo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RootController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
}
