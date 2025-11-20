package io.github.aronangeles.athletika.model;

import lombok.Getter;

@Getter
public enum WorkoutFocus {
    BACK("Back"),
    CHEST("Chest"),
    SHOULDER("Shoulder"),
    ARMS("Arms"),
    CORE("Core");

    private final String focus;

    WorkoutFocus(String focus) {
        this.focus = focus;
    }
}
