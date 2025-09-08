package com.example.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityRequest {

    @NotNull(message = "User ID cannot be Empty.")
    private Long userId;

    @NotBlank(message = "Activity type cannot Empty.")
    private String activityType;

    @NotNull(message = "Duration cannot be Empty.")
    @Positive(message = "Duration must be a positive number.")
    private Integer duration;

    @NotNull(message = "Calories burned cannot be Empty.")
    @PositiveOrZero(message = "Calories burned must be zero or a positive number.")
    private Integer caloriesBurned;

    @NotNull(message = "Start time cannot be Empty.")
    @PastOrPresent(message = "The activity start time must be in the past or present.")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startedAt;

}
