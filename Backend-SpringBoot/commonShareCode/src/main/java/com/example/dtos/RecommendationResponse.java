package com.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendationResponse {
    private String id;
    private Long userId;
    private Long activityId;
    private String activityType;
    private String recommendation;
    private List<String> improvement;
    private List<String> suggestion;
    private List<String> safety;
    private LocalDateTime createdAt;
}
