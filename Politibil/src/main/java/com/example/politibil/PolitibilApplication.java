package com.example.politibil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PolitibilApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolitibilApplication.class, args);
    }

    //For http request
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
