package org.musinsa.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BffHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffHomeworkApplication.class, args);
    }

}
