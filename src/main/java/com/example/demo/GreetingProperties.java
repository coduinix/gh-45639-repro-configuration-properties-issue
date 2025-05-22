package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix="demo.greeting")
public class GreetingProperties {
    private String message = "Default Message";

    private GreetingDetailsProperties details = new GreetingDetailsProperties();

    @Setter
    @Getter
    static class GreetingDetailsProperties {
        String salutation = "Default Salutation";
    }
}
