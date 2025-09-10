package com.aiService.service;

import com.aiService.repository.AiServiceRepo;
import com.example.dtos.RecommendationResponse;
import com.example.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final AiServiceRepo repo;

    public List<RecommendationResponse> userRecommendation(Long userId) {
        return repo.findByUserId(userId);
    }

    public RecommendationResponse activityRecommendation(Long activityId) {
        return repo.findByActivityId(activityId).orElseThrow(()->new UserNotFound("Activity Doesn't Exists..!"));
    }
}
