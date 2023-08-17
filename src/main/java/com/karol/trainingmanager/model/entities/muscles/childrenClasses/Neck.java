package com.karol.trainingmanager.model.entities.muscles.childrenClasses;

import com.karol.trainingmanager.model.entities.muscles.parentClasses.Muscle;
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
@SequenceGenerator(name = "seq_test", sequenceName = "seq_test", allocationSize = 1)
public class Neck extends Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_test")
    private Long id;
}
