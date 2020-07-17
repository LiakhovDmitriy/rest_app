package com.gmail.dimaliahov;

import com.gmail.dimaliahov.model.Personage;
import com.gmail.dimaliahov.repository.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
