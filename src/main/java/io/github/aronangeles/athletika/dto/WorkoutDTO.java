package io.github.aronangeles.athletika.dto;

import io.github.aronangeles.athletika.model.Workout;
import lombok.Data;

@Data
public class WorkoutDTO {

    private Integer id;
    private String name;
    private Integer sets;
    private Integer reps;

    public  WorkoutDTO(Workout workout) {
        this.id = workout.getId();
        this.name = String.valueOf(workout.getName());
        this.sets = workout.getSets();
        this.reps = workout.getReps();
    }



}
