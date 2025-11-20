package io.github.aronangeles.athletika.services;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Query;
import io.github.aronangeles.athletika.model.UpdateWorkoutCommand;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import io.github.aronangeles.athletika.validators.WorkoutValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateWorkoutService implements Query<UpdateWorkoutCommand, WorkoutDTO> {

    private final WorkoutRepository workoutRepository;

    public UpdateWorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }


    @Override
    public ResponseEntity<WorkoutDTO> execute(UpdateWorkoutCommand input) {

        Optional<Workout> workoutOptional = workoutRepository.findById(input.getId());

        if (workoutOptional.isPresent()) {
            Workout workout = input.getWorkout();
            WorkoutValidator.validate(workout);
            workout.setId(input.getId());
            workoutRepository.save(workout);
            return ResponseEntity.ok(new WorkoutDTO(workout));
        }

        return ResponseEntity.notFound().build();

    }
}
