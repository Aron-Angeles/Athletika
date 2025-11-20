package io.github.aronangeles.athletika.validators;

import io.github.aronangeles.athletika.exceptions.ErrorMessages;
import io.github.aronangeles.athletika.exceptions.WorkoutNotValidException;
import io.github.aronangeles.athletika.model.Workout;
import org.springframework.util.StringUtils;

public class WorkoutValidator {

    private WorkoutValidator() {

    }

    public static void validate(Workout workout) {

        if(!StringUtils.hasText(String.valueOf(workout.getName()))) {
            throw new WorkoutNotValidException(ErrorMessages.INVALID_NAME.getMessage());
        }

        if(!StringUtils.hasText(String.valueOf(workout.getFocus()))){
            throw new WorkoutNotValidException(ErrorMessages.INVALID_FOCUS.getMessage());
        }

        if(workout.getSets() <= 0 || workout.getSets() > 20 ) {
            throw new WorkoutNotValidException(ErrorMessages.INVALID_SETS.getMessage());
        }

        if(workout.getReps() <= 0 || workout.getReps() > 30 ) {
            throw new WorkoutNotValidException(ErrorMessages.INVALID_REPS.getMessage());
        }

    }


}
