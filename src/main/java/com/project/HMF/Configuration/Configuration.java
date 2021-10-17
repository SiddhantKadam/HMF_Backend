package com.project.HMF.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory)
    {
        return  hibernateEntityManagerFactory.getSessionFactory();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/").allowedOrigins("*");
            }
        };
    }

}