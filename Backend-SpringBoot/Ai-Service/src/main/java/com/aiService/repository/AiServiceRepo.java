package com.aiService.repository;

import com.aiService.model.Recommendation;
import com.example.dtos.RecommendationResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AiServiceRepo extends MongoRepository<Recommendation , Long> {
    List<RecommendationResponse> findByUserId(Long userId);

    Optional<RecommendationResponse> findByActivityId(Long activityId);
}
