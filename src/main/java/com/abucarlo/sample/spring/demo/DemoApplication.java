package com.abucarlo.sample.spring.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Comparator;
import java.util.Map;
import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

    private final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

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
        properties.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Object::toString))).forEachOrdered(entry -> logger.info("{} => {}", entry.getKey(), entry.getValue()));
        return new MyService(properties);
    }

    @ConfigurationProperties
    @Bean
    public Properties getProperties() {
        return new Properties();
    }
}
