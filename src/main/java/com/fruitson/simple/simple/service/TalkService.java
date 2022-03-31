package com.fruitson.simple.simple.service;

import com.fruitson.simple.simple.model.Talk;
import com.fruitson.simple.simple.notion.model.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TalkService {

    public static Talk mapPageToTalk(Page page) {
        return Talk.builder()
                   .id(page.getId())
                   .title(page.getProperties().get("Title").get("title").get(0).get("text").get("content").asText())
                   .startDate(LocalDateTime.parse(page.getProperties().get("StartDate").get("date").get("start").asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                   .endDate(LocalDateTime.parse(page.getProperties().get("EndDate").get("date").get("start").asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                   .build();
    }
}
