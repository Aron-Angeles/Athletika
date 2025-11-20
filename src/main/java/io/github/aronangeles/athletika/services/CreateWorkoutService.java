package io.github.aronangeles.athletika.services;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Query;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import io.github.aronangeles.athletika.validators.WorkoutValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateWorkoutService implements Query<Workout, WorkoutDTO> {

    private final WorkoutRepository workoutRepository;

    public CreateWorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public ResponseEntity<WorkoutDTO> execute(Workout workout) {
        WorkoutValidator.validate(workout);
        Workout savedWorkout = workoutRepository.save(workout);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new WorkoutDTO(savedWorkout));
    }

}
