package io.github.aronangeles.athletika;

import io.github.aronangeles.athletika.dto.WorkoutDTO;
import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.model.WorkoutFocus;
import io.github.aronangeles.athletika.model.WorkoutNames;
import io.github.aronangeles.athletika.repositories.WorkoutRepository;
import io.github.aronangeles.athletika.services.GetAllWorkoutService;
import org.hibernate.jdbc.Work;
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
public class GetAllWorkoutServiceTest {

    @Mock
    private WorkoutRepository workoutRepository;

    @InjectMocks
    private GetAllWorkoutService getAllWorkoutService;

    @Test
    public void givenVoid_whenWorkoutExist_thenReturnWorkoutDTO() {
        Workout workout = new Workout();
        workout.setId(1);
        workout.setName(WorkoutNames.LAT_PULLDOWN);
        workout.setFocus(WorkoutFocus.BACK);
        workout.setSets(3);
        workout.setReps(12);

        given(workoutRepository.findAll()).willReturn(List.of(workout));

        ResponseEntity<List<WorkoutDTO>> response = getAllWorkoutService.execute(null);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).hasSize(1);

        WorkoutDTO dto = response.getBody().get(0);
        assertThat(dto.getId()).isEqualTo(workout.getId());
        assertThat(dto.getName()).isEqualTo(String.valueOf(workout.getName()));
        assertThat(dto.getSets()).isEqualTo(workout.getSets());
        assertThat(dto.getReps()).isEqualTo(workout.getReps());
    }

    @Test
    public void givenVoid_whenNoWorkoutExist_thenReturnNoWorkoutDTO() {

        given(workoutRepository.findAll()).willReturn(List.of());

        ResponseEntity<List<WorkoutDTO>> response = getAllWorkoutService.execute(null);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();

    }

}
