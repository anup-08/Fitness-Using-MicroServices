package com.activityService.controller;

import com.activityService.service.ActivityService;
import com.example.dtos.ActivityRequest;
import com.example.dtos.ActivityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService service;

    @PostMapping("/addActivity")
    public ResponseEntity<ActivityResponse> registerActivity(@Valid @RequestBody ActivityRequest request){
        return ResponseEntity.ok(service.trackActivity(request));
    }

    @GetMapping("/isActivityValid/{activityId}")
    public ResponseEntity<Boolean> isActivityValid(@PathVariable Long activityId){
        return ResponseEntity.ok(service.isActivityValid(activityId));
    }
}
