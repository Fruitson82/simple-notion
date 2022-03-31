package com.fruitson.simple.simple.notion;

import com.fruitson.simple.simple.notion.service.DatabaseService;
import org.springframework.stereotype.Component;

@Component
public class NotionClient {

    public final DatabaseService database;

    public NotionClient(DatabaseService databaseService) {
        this.database = databaseService;
    }

    // client.database.query('21314124')
}
