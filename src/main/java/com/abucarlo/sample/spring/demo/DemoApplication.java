package com.abucarlo.sample.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

    public static class MyService {
        private final Properties properties;

        public MyService(Properties properties) {
            this.properties = properties;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public MyService createService() {
        Properties properties = getProperties();
        return new MyService(properties);
    }

    @ConfigurationProperties
    @Bean
    public Properties getProperties() {
        return new Properties();
    }
}
