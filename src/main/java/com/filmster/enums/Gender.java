package com.filmster.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("M", "male"),
    FEMALE("F", "female");

    private final String code;
    private final String name;

    Gender(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gender : " + code;
    }
}
