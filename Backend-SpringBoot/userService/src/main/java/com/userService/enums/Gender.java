package com.userService.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    TRANSGENDER("Trans");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

}
