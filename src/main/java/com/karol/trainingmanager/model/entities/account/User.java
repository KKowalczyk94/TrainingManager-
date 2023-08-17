package com.karol.trainingmanager.model.entities.account;

import com.karol.trainingmanager.model.entities.buisnessLogic.Training;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long id;
    private String userName;
    private String userPassword;
    private Integer weight;
    private Integer height;
    @OneToMany
    @JoinColumn(name = "userTrainings")
    private List<Training> userTrainings;
}
