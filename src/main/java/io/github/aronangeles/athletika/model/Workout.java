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
    private String focus;

    @Column(name="name")
    private String name;

    @Column(name="sets")
    private Integer sets;

    @Column(name="reps")
    private Integer reps;

}
