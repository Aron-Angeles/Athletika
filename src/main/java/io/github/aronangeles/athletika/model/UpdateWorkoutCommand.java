package io.github.aronangeles.athletika.model;

import lombok.Getter;

@Getter
public class UpdateWorkoutCommand {
    private Integer id;
    private Workout workout;

    public UpdateWorkoutCommand(Integer id, Workout workout) {
        this.id = id;
        this.workout = workout;
    }
}
