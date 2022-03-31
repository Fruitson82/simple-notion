package com.fruitson.simple.simple.notion.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter @Setter
@Configuration
@ConfigurationProperties("notion")
public class NotionConfigProperties {

    private String apiUrl;
    private String apiVersion;
    private String databaseId;
    private String authToken;
}
