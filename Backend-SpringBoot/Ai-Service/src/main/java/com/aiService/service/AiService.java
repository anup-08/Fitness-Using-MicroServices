package com.aiService.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class AiService {

    @Value("${gemini-2.0-flash-url}")
    private  String geminiApiUrl;
    @Value("${gemini-2.0-flash-key}")
    private  String geminiApiKey;

    private final WebClient webClient;

    public AiService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }


    public String getRecommendation(String details){
        Map<String , Object> requestBody = Map.of("contents", new Object[]{
                Map.of("parts",new Object[]{
                        Map.of("text", details)
                })
        });

        return webClient.post()
                .uri(geminiApiUrl)
                .header("Content-Type","application/json")
                .header("X-goog-api-key",geminiApiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
