package com.fruitson.simple.simple;

import com.fruitson.simple.simple.notion.config.NotionConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NotionConfigProperties.class)
public class SimpleNotionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleNotionApplication.class, args);
    }

}
