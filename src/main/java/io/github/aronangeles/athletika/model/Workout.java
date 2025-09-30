package io.github.aronangeles.athletika.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="focus")
    private String focus;

    @Column(name="name")
    private String name;

    @Column(name="sets")
    private int sets;

    @Column(name="reps")
    private int reps;

}
