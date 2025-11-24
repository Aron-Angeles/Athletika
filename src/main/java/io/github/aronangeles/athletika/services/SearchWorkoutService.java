package io.github.aronangeles.athletika.services;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Query;
import io.github.aronangeles.athletika.model.WorkoutFocus;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchWorkoutService implements Query<String, List<WorkoutDTO>> {

    private final WorkoutRepository workoutRepository;

    public SearchWorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }


    @Override
    public ResponseEntity<List<WorkoutDTO>> execute(String input) {
        return ResponseEntity.ok(workoutRepository.findByFocus(WorkoutFocus.valueOf(input))
                .stream()
                .map(WorkoutDTO::new)
                .toList());

    }
}
