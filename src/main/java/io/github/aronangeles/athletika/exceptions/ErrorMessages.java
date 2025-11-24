package io.github.aronangeles.athletika.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    INVALID_WORKOUT("Invalid workout"),
    INVALID_NAME("Workout name is invalid"),
    INVALID_SETS("Sets are invalid"),
    INVALID_REPS("Reps are invalid"),
    INVALID_FOCUS("Focus is invalid"),
    WORKOUT_NOT_FOUND("Workout not found"),;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
