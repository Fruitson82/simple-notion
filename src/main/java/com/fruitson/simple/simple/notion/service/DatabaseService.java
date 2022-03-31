package com.fruitson.simple.simple.notion.service;

import com.fruitson.simple.simple.notion.config.NotionConfigProperties;
import com.fruitson.simple.simple.notion.model.Database;
import com.fruitson.simple.simple.notion.model.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DatabaseService {

    private final Logger log = LoggerFactory.getLogger(DatabaseService.class);
    private final NotionConfigProperties notionConfigProperties;
    private final RestTemplate restTemplate;

    public DatabaseService(NotionConfigProperties notionConfigProperties, RestTemplate restTemplate) {
        this.notionConfigProperties = notionConfigProperties;
        this.restTemplate = restTemplate;
    }

    public List<Page> query(String databaseId) {
        String url = notionConfigProperties.getApiUrl() + "/v1/databases/" + databaseId + "/query";
        log.info("Querying Notion database: {}", url);
        ResponseEntity<Database> db = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(getDefaultheaders()),
                Database.class
        );
        return db.getBody().getPages();
    }

    private HttpHeaders getDefaultheaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Notion-Version", notionConfigProperties.getApiVersion());
        headers.set("Authorization", notionConfigProperties.getAuthToken());
        return headers;
    }

}
