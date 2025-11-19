package io.github.aronangeles.athletika.services;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Query;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteWorkoutService implements Query<Integer, Void> {

    private final WorkoutRepository workoutRepository;

    public DeleteWorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        return null;
    }
}
