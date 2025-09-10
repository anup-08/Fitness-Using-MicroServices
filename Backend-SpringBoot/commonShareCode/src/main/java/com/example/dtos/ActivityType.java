package com.example.dtos;

import lombok.Getter;

@Getter
public enum ActivityType {
    RUNNING("Running"),
    WALKING("Walking"),
    CYCLING("Cycling"),
    SWIMMING("Swimming"),
    WEIGHT_TRAINING("Weight Training"),
    YOGA("Yoga"),
    HIIT("Hiit"),
    CARDIO("Cardio"),
    STRETCHING("Stretching"),
    OTHER("Other");

    private final String displayName;

    ActivityType(String displayName){
        this.displayName = displayName;
    }

}
