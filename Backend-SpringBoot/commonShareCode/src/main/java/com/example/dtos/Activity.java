package com.example.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class Activity {
    private Long id;
    private Long userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
