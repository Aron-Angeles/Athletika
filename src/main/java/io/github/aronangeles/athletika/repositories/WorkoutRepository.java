package io.github.aronangeles.athletika.repositories;

import io.github.aronangeles.athletika.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Integer> {

    @Query("SELECT x FROM Workout x where x.focus = ?1")
    List<Workout> findByFocus(String focus);


}
