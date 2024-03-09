package com.example.ouath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OuathApplication {

    public static void main(String[] args) {
        SpringApplication.run(OuathApplication.class, args);
    }

}
