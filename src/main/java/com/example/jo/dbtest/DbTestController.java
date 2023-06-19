package com.example.jo.dbtest;

import com.example.jo.RootController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "db-test")
public class DbTestController {
    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private DbTestService dbTestService;

    @GetMapping("/test")
    public String sayHello() {
        logger.debug("TEST");
        dbTestService.testDbConnector();
        return "Testing!";
    }
}
