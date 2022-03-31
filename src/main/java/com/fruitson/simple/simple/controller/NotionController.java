package com.fruitson.simple.simple.controller;

import com.fruitson.simple.simple.model.Talk;
import com.fruitson.simple.simple.notion.NotionClient;
import com.fruitson.simple.simple.notion.config.NotionConfigProperties;
import com.fruitson.simple.simple.notion.model.Page;
import com.fruitson.simple.simple.service.TalkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notion")
public class NotionController {

    private final NotionClient client;
    private final NotionConfigProperties notionConfigProperties;

    public NotionController(NotionClient client, NotionConfigProperties notionConfigProperties) {
        this.client = client;
        this.notionConfigProperties = notionConfigProperties;
    }

    @GetMapping
    public List<Talk> findAll() {
        List<Page> pages = client.database.query(notionConfigProperties.getDatabaseId());
        return pages.stream().map(TalkService::mapPageToTalk).collect(Collectors.toList());
    }
}
