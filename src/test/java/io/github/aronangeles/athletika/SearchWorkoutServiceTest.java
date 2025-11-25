package io.github.aronangeles.athletika;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.model.WorkoutFocus;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import io.github.aronangeles.athletika.services.SearchWorkoutService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class SearchWorkoutServiceTest {

    @Mock
    private WorkoutRepository workoutRepository;

    @InjectMocks
    private SearchWorkoutService searchWorkoutService;

    @Test
    public void givenValidWorkoutFocus_whenSearchWorkoutFocusExist_thenReturnListOfWorkoutsDTOs() {
        Workout workout = new Workout();
        workout.setId(1);
        workout.setFocus(WorkoutFocus.BACK);

        given(workoutRepository.findByFocus(workout.getFocus())).willReturn(List.of(workout));

        ResponseEntity<List<WorkoutDTO>> response = searchWorkoutService.execute(String.valueOf(workout.getFocus()));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().size()).isEqualTo(1);

        WorkoutDTO workoutDTO = response.getBody().get(0);
        assertThat(workoutDTO.getId()).isEqualTo(workout.getId());
    }

    @Test
    public void givenValidWorkoutFocus_whenSearchWorkoutFocusNotExist_thenReturnEmptyList() {
        Workout workout = new Workout();
        workout.setFocus(WorkoutFocus.BACK);

        given(workoutRepository.findByFocus(workout.getFocus())).willReturn(List.of());

        ResponseEntity<List<WorkoutDTO>> response = searchWorkoutService.execute(String.valueOf(workout.getFocus()));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().size()).isEqualTo(0);
        assertThat(response.getBody().isEmpty());
    }
}
