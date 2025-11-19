package io.github.aronangeles.athletika.model;

import lombok.Getter;

@Getter
public class UpdateWorkoutCommand {
    private final Integer id;
    private final Workout workout;

    public UpdateWorkoutCommand(Integer id, Workout workout) {
        this.id = id;
        this.workout = workout;
    }
}
