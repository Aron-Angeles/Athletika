package io.github.aronangeles.athletika.controllers;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.UpdateWorkoutCommand;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.services.CreateWorkoutService;
import io.github.aronangeles.athletika.services.DeleteWorkoutService;
import io.github.aronangeles.athletika.services.GetAllWorkoutService;
import io.github.aronangeles.athletika.services.UpdateWorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutController {

    private final CreateWorkoutService createWorkoutService;
    private final DeleteWorkoutService deleteWorkoutService;
    private final GetAllWorkoutService getAllWorkoutService;
    private final UpdateWorkoutService updateWorkoutService;

    public WorkoutController(CreateWorkoutService createWorkoutService,
                             DeleteWorkoutService deleteWorkoutService,
                             GetAllWorkoutService getAllWorkoutService,
                             UpdateWorkoutService updateWorkoutService) {
        this.createWorkoutService = createWorkoutService;
        this.deleteWorkoutService = deleteWorkoutService;
        this.getAllWorkoutService = getAllWorkoutService;
        this.updateWorkoutService = updateWorkoutService;
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
        return updateWorkoutService.execute(new UpdateWorkoutCommand(id, workout));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkout(@PathVariable Integer id) {
        return deleteWorkoutService.execute(id);
    }


}
