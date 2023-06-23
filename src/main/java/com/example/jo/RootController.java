package com.example.jo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public String sayHello() {
        logger.debug("TEST");
        return "Hello World!";
    }
}
