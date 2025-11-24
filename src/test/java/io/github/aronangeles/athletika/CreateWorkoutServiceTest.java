package io.github.aronangeles.athletika;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.exceptions.WorkoutNotValidException;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.model.WorkoutFocus;
import io.github.aronangeles.athletika.model.WorkoutNames;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import io.github.aronangeles.athletika.services.CreateWorkoutService;
import io.github.aronangeles.athletika.validators.WorkoutValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class CreateWorkoutServiceTest {

    @Mock
    private WorkoutRepository workoutRepository;

    @InjectMocks
    private CreateWorkoutService createWorkoutService;

    @Test
    public void givenValidWorkout_whenExecute_thenReturnCreatedWorkoutDTO(){

        Workout workout = new Workout();
        workout.setId(1);
        workout.setName(WorkoutNames.BARBELL_ROW);
        workout.setFocus(WorkoutFocus.BACK);
        workout.setSets(3);
        workout.setReps(12);
        given(workoutRepository.save(workout)).willReturn(workout);

        ResponseEntity<WorkoutDTO> result = createWorkoutService.execute(workout);

        assertThat(ResponseEntity.status(HttpStatus.CREATED).body(new WorkoutDTO(workout))).isEqualTo(result);
        then(workoutRepository).should(Mockito.times(1)).save(workout);
    }
}
