package com.karol.trainingmanager.model.entities.muscles.parentClasses;

import jakarta.persistence.*;

@Entity
public class Muscle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_muscle")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
}
