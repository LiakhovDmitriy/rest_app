package com.gmail.dimaliahov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestAppSpring {
    public static void main(String[] args) {
        SpringApplication.run(RestAppSpring.class, args);
    }
}
