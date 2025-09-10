package com.aiService.controller;

import com.aiService.service.RecommendationService;
import com.example.dtos.RecommendationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ai")
@AllArgsConstructor
public class Controller {
    private final RecommendationService service;

    @GetMapping("/userRec/{userId}")
    public ResponseEntity<List<RecommendationResponse>> userRecommendation(@PathVariable Long userId){
        return ResponseEntity.ok(service.userRecommendation(userId));
    }


    @GetMapping("/activityRec/{activityId}")
    public ResponseEntity<RecommendationResponse> activityRecommendation(@PathVariable Long activityId){
        return ResponseEntity.ok(service.activityRecommendation(activityId));

    }
}
