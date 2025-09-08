package com.activityService.controller;

import com.activityService.service.ActivityService;
import com.example.dtos.ActivityRequest;
import com.example.dtos.ActivityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService service;

    @PostMapping("/addActivity")
    public ResponseEntity<ActivityResponse> registerActivity(@Valid @RequestBody ActivityRequest request){
        return ResponseEntity.ok(service.trackActivity(request));
    }
}
