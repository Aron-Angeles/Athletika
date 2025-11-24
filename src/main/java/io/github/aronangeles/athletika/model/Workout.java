package io.github.aronangeles.athletika.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="focus")
    @Enumerated(EnumType.STRING)
    private WorkoutFocus focus;

    @Column(name="name")
    @Enumerated(EnumType.STRING)
    private WorkoutNames name;

    @Column(name="sets")
    private Integer sets;

    @Column(name="reps")
    private Integer reps;

}
