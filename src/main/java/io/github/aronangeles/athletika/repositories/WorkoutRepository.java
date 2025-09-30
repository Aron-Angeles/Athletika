package io.github.aronangeles.athletika.repositories;

import io.github.aronangeles.athletika.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Integer> {

}
