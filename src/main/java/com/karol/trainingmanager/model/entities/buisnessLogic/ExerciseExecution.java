package com.karol.trainingmanager.model.entities.buisnessLogic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@SequenceGenerator(name = "seq_exercise_execution", sequenceName = "seq_exercise_execution", allocationSize = 1)
public class ExerciseExecution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_exercise_execution")
    private int sets;
    private int reps;
    private int repsInReserve;
    private int weight;
    private Long timeOfExecution;

}
