package io.github.aronangeles.athletika.services;

import io.github.aronangeles.athletika.exceptions.WorkoutNotFoundException;
import io.github.aronangeles.athletika.model.Query;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteWorkoutService implements Query<Integer, Void> {

    private final WorkoutRepository workoutRepository;

    public DeleteWorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        Optional<Workout> workoutOptional = workoutRepository.findById(input);

        if (workoutOptional.isPresent()) {
            workoutRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }

        throw new WorkoutNotFoundException();
    }
}
