package com.bardan.mydog24crm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Zezwalaj na połączenia z lokalnego front-endu (deweloperskie)
        registry.addMapping("/**") // dotyczy wszystkich ścieżek API
                .allowedOrigins("http://localhost:58515") // DODAJ DOKŁADNIE TEN PORT I SCHEMAT
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

        // Dodaj swoją produkcyjną domenę, gdy ją wdrożysz na Firebase:
        // .allowedOrigins("https://twoja-domena-firebase.web.app");
    }
}