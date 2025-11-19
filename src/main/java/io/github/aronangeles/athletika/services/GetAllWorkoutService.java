package io.github.aronangeles.athletika.services;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Query;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllWorkoutService implements Query<Void,List<WorkoutDTO>> {

    private final WorkoutRepository workoutRepository;

    public GetAllWorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public ResponseEntity<List<WorkoutDTO>> execute(Void input) {
        List<Workout> workouts = workoutRepository.findAll();
        List<WorkoutDTO> workoutDTOs = workouts.stream().map(WorkoutDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(workoutDTOs);

    }

}
