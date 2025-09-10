package com.aiService.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collation = "aiServices")
@Data
@Builder
public class Recommendation {
    @Id
    private Long id;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Activity ID cannot be null")
    private Long activityId;

    private String recommendation;
    private List<String> improvement;
    private List<String> suggestion;
    private List<String> safety;


    @CreatedDate
    private LocalDateTime createdAt;


}
