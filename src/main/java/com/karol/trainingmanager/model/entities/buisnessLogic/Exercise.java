package com.karol.trainingmanager.model.entities.buisnessLogic;


import com.karol.trainingmanager.model.entities.muscles.parentClasses.Muscle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@SequenceGenerator(name = "seq_exercise", sequenceName = "seq_exercise", allocationSize = 1)
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_exercise")
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ExerciseType exerciseType;
    @OneToOne
    @JoinColumn(name = "exercise_execution_id")
    private ExerciseExecution exerciseExecution;
    @OneToMany //TODO: check mappedBy with the super class for several sub classes
    @JoinColumn(name = "muscles_activated_id")
    private List<Muscle> musclesActivated;
    // private Map<Muscle, Integer> levelOfMuscleActivation;
    private String comments;
    private String accesories;

    public void setExerciseExecution(ExerciseExecution exerciseExecution) {
        this.exerciseExecution = exerciseExecution;
    }
}
