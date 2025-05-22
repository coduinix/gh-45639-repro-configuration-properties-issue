package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
    @Autowired
    GreetingProperties greetingProperties;

    @GetMapping("/hello")
    public String hello() {
        return "%s, %s".formatted(greetingProperties.getDetails().salutation, greetingProperties.getMessage());
    }
}
