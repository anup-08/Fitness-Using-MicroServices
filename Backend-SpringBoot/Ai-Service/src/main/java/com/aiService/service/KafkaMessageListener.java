package com.aiService.service;

import com.example.dtos.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "${kafka-topic-name}" , groupId = "activity-event-group01")
    public void processListener(Activity activity){
        log.info("Received message for user id "+activity.getUserId());
    }
}
