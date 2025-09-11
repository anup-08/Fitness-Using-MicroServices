package com.activityService.service;

import com.activityService.enums.ActivityType;
import com.activityService.fiegnClient.FeignClient;
import com.activityService.model.Activity;
import com.activityService.repo.ActivityRepository;
import com.example.dtos.ActivityRequest;
import com.example.dtos.ActivityResponse;
import com.example.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {

    private final ActivityRepository repo;
    private final FeignClient feignClient;
    private final KafkaTemplate<Long , Activity> kafkaTemplate;

    @Value("${kafka-topic-name}")
    private String topicName;

    public ActivityResponse trackActivity(ActivityRequest request) {

        if(!feignClient.isUSerValid(request.getUserId())){
            throw new UserNotFound("User Doesn't Exists..!");
        }

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

        Activity newActivity = repo.save(activity);

        try{
            log.atInfo().log("Adding messages at kafka....");
            kafkaTemplate.send(topicName , newActivity.getUserId() , newActivity);
            log.atInfo().log("messages added at kafka....");
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while adding message in Message Broker");
        }

        return response(newActivity);
    }

    public Boolean isActivityValid(Long activityId) {
        return repo.existsById(activityId);
    }

    private ActivityResponse response(Activity activity){
        return new ActivityResponse(activity.getId(), activity.getUserId(), activity.getType().getDisplayName() ,
                activity.getDuration(),activity.getCaloriesBurned(),activity.getStartedAt(),
                activity.getCreatedAt(),activity.getUpdatedAt());
    }


}
