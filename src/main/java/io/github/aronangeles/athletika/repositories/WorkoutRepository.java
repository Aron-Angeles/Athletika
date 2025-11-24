package io.github.aronangeles.athletika.repositories;

import io.github.aronangeles.athletika.model.Workout;
import io.github.aronangeles.athletika.model.WorkoutFocus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Integer> {

    @Query("SELECT x FROM Workout x WHERE x.focus = :focus")
    List<Workout> findByFocus(WorkoutFocus focus);
}
