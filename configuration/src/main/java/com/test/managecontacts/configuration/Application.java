package com.test.managecontacts.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.test.managecontacts"})
@EntityScan("com.test.managecontacts.db.model")
@EnableJpaRepositories("com.test.managecontacts.db")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
