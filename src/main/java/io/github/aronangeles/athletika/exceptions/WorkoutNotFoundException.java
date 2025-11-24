package io.github.aronangeles.athletika.exceptions;


public class WorkoutNotFoundException extends RuntimeException {

    public WorkoutNotFoundException() {
        super(ErrorMessages.WORKOUT_NOT_FOUND.getMessage());
    }
}
