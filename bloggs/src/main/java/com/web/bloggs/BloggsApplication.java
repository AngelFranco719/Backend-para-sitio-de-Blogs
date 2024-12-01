package com.web.bloggs;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BloggsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggsApplication.class, args);
        System.out.println("DB_URL: " + System.getenv("DB_URL"));
        System.out.println("DB_USER_NAME: " + System.getenv("DB_USER_NAME"));
        System.out.println("DB_PASSWORD: " + System.getenv("DB_PASSWORD"));
        System.out.println("DB_NAME: " + System.getenv("DB_NAME"));
    }

    @PostConstruct
    public void checkEnvVariables() {
        System.out.println("DB_URL: " + System.getenv("DB_URL"));
        System.out.println("DB_USER_NAME: " + System.getenv("DB_USER_NAME"));
        System.out.println("DB_PASSWORD: " + System.getenv("DB_PASSWORD"));
    }

}
