package com.filmster.enums;

import lombok.Getter;

@Getter
public enum Popularity {

    LOW("LOW", "low"),
    MEDIUM("MEDIUM", "medium"),
    HIGH("HIGH", "high");

    private final String code;
    private final String name;

    Popularity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Popularity : " + code;
    }
}
