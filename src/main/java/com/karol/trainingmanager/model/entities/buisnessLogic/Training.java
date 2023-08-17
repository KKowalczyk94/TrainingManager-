package com.karol.trainingmanager.model.entities.buisnessLogic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@SequenceGenerator(name = "seq_training", sequenceName = "seq_training", allocationSize = 1)
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_training")
    private String name;
    @OneToMany
    @JoinColumn(name = "exercises")
    private List<Exercise> exercises;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar dateOfTraining;
    private String comments;
}
