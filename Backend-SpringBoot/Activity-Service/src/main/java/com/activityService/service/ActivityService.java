package com.activityService.service;

import com.activityService.enums.ActivityType;
import com.activityService.model.Activity;
import com.activityService.repo.ActivityRepository;
import com.example.dtos.ActivityRequest;
import com.example.dtos.ActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository repo;

    public ActivityResponse trackActivity(ActivityRequest request) {

        ActivityType type;
        try {
            type = ActivityType.valueOf(request.getActivityType().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Activity Type..!");
        }
        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(type)
                .caloriesBurned(request.getCaloriesBurned())
                .duration(request.getDuration())
                .startedAt(request.getStartedAt())
                .build();

        return response(repo.save(activity));
    }

    private ActivityResponse response(Activity activity){
        return new ActivityResponse(activity.getId(), activity.getUserId(), activity.getType().getDisplayName() ,
                activity.getDuration(),activity.getCaloriesBurned(),activity.getStartedAt(),
                activity.getCreatedAt(),activity.getUpdatedAt());
    }
}
