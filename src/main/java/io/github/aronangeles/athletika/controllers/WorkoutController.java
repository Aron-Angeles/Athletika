package io.github.aronangeles.athletika.controllers;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.services.CreateWorkoutService;
import io.github.aronangeles.athletika.services.DeleteWorkoutService;
import io.github.aronangeles.athletika.services.GetAllWorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutController {

    private final CreateWorkoutService createWorkoutService;
    private final DeleteWorkoutService deleteWorkoutService;
    private final GetAllWorkoutService getAllWorkoutService;

    public WorkoutController(CreateWorkoutService createWorkoutService,
                             DeleteWorkoutService deleteWorkoutService,
                             GetAllWorkoutService getAllWorkoutService) {
        this.createWorkoutService = createWorkoutService;
        this.deleteWorkoutService = deleteWorkoutService;
        this.getAllWorkoutService = getAllWorkoutService;
    }

    @PostMapping("/workout")
    public ResponseEntity<WorkoutDTO> createWorkout(@RequestBody Workout workout) {
        return createWorkoutService.execute(workout);
    }

    @GetMapping("/workout")
    public ResponseEntity<List<WorkoutDTO>> getWorkout() {
        return getAllWorkoutService.execute(null);
    }

    @PutMapping
    public ResponseEntity<WorkoutDTO> updateWorkout(@PathVariable Integer id, @RequestBody Workout workout) {
        return
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkout(@PathVariable Integer id) {
        return deleteWorkoutService.execute(id);
    }


}
