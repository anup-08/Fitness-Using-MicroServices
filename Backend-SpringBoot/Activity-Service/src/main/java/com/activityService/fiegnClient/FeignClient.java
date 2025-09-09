package com.activityService.fiegnClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.cloud.openfeign.FeignClient(name = "userService")
public interface FeignClient {

    @GetMapping("/auth/isValid/{userId}")
    public Boolean isUSerValid(@PathVariable  Long userId);
}
