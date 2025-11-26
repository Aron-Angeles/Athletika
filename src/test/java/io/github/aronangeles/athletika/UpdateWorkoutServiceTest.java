package io.github.aronangeles.athletika;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.exceptions.WorkoutNotFoundException;
import io.github.aronangeles.athletika.model.UpdateWorkoutCommand;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.model.WorkoutFocus;
import io.github.aronangeles.athletika.model.WorkoutNames;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import io.github.aronangeles.athletika.services.UpdateWorkoutService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UpdateWorkoutServiceTest {

    @Mock
    private WorkoutRepository workoutRepository;

    @InjectMocks
    private UpdateWorkoutService updateWorkoutService;

    @Test
    public void givenValidWorkout_whenWorkoutExist_thenReturnWorkoutDTO()
    {
        Workout workout = new Workout();
        workout.setFocus(WorkoutFocus.BACK);
        workout.setName(WorkoutNames.BARBELL_ROW);
        workout.setReps(3);
        workout.setSets(12);
        workout.setId(1);

        Workout newWorkout = new Workout();
        newWorkout.setId(1);
        newWorkout.setName(WorkoutNames.DUMBBELL_BENCH_PRESS);
        newWorkout.setFocus(WorkoutFocus.CHEST);
        newWorkout.setReps(8);
        newWorkout.setSets(2);

        given(workoutRepository.findById(workout.getId())).willReturn(Optional.of(workout));

        ResponseEntity<WorkoutDTO> response = updateWorkoutService.execute(new UpdateWorkoutCommand(1, newWorkout));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        WorkoutDTO workoutDTO = response.getBody();
        assertThat(WorkoutNames.valueOf(workoutDTO.getName())).isEqualTo(WorkoutNames.DUMBBELL_BENCH_PRESS);
        assertThat(workoutDTO.getSets()).isEqualTo(newWorkout.getSets());
        assertThat(workoutDTO.getReps()).isEqualTo(newWorkout.getReps());

        then(workoutRepository).should(times(1)).findById(workout.getId());

    }

    @Test
    public void givenValidWorkout_whenWorkoutDoesNotExist_thenReturnNotFound(){
        Workout newWorkout = new Workout();
        newWorkout.setId(1);
        newWorkout.setName(WorkoutNames.DUMBBELL_BENCH_PRESS);
        newWorkout.setFocus(WorkoutFocus.CHEST);
        newWorkout.setReps(8);
        newWorkout.setSets(2);

        assertThatThrownBy(() -> updateWorkoutService.execute(new UpdateWorkoutCommand(1, newWorkout)))
                .isInstanceOf(WorkoutNotFoundException.class)
                .hasMessage("Workout not found");
    }
}
