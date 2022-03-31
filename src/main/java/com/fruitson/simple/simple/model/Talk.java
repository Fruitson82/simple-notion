package com.fruitson.simple.simple.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Talk {
    private String id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
