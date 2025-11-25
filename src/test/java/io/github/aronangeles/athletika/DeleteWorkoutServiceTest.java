package io.github.aronangeles.athletika;

import io.github.aronangeles.athletika.exceptions.WorkoutNotFoundException;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import io.github.aronangeles.athletika.services.DeleteWorkoutService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
public class DeleteWorkoutServiceTest {

    @Mock
    private WorkoutRepository workoutRepository;

    @InjectMocks
    private DeleteWorkoutService deleteWorkoutService;

    @Test
    public void givenID_whenWorkoutExist_thenReturnNoContent(){

        Workout workout = new Workout();
        workout.setId(1);

        given(workoutRepository.findById(workout.getId())).willReturn(Optional.of(workout));

        ResponseEntity<Void> response = deleteWorkoutService.execute(workout.getId());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        then(workoutRepository).should().deleteById(workout.getId());
    }

    @Test
    public void givenID_whenWorkoutNotExist_thenReturnNotFound(){
        assertThatThrownBy(() -> deleteWorkoutService.execute(1))
                .isInstanceOf(WorkoutNotFoundException.class)
                .hasMessage("Workout not found");
    }


}
