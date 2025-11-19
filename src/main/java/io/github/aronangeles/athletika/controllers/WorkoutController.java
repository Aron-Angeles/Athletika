package io.github.aronangeles.athletika.controllers;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.services.CreateWorkoutService;
import io.github.aronangeles.athletika.services.DeleteWorkoutService;
import io.github.aronangeles.athletika.services.GetWorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkoutController {

    private final CreateWorkoutService createWorkoutService;
    private final DeleteWorkoutService deleteWorkoutService;
    private final GetWorkoutService getWorkoutService;

    public WorkoutController(CreateWorkoutService createWorkoutService,
                             DeleteWorkoutService deleteWorkoutService,
                             GetWorkoutService getWorkoutService) {
        this.createWorkoutService = createWorkoutService;
        this.deleteWorkoutService = deleteWorkoutService;
        this.getWorkoutService = getWorkoutService;
    }

    @PostMapping("/workout")
    public ResponseEntity<WorkoutDTO> createWorkout(@RequestBody Workout workout) {
        return createWorkoutService.execute(workout);
    }

    @GetMapping
    public ResponseEntity<WorkoutDTO> getWorkout(@RequestParam Integer input) {
        return getWorkoutService.execute(input);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkout(@PathVariable Integer id) {
        return deleteWorkoutService.execute(id);
    }


}
