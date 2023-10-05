package com.karol.trainingmanager.model.entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate
@Table(name = "SR_MAP_HEADER")
public class SrMapHeader extends AuditingEntity {
    @Id
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "SUB_SYSTEM")
    private Short subSystem;

    @NotBlank
    @Length(max = 3)
    @Column(name = "EXTRACT_TYPE")
    private String extractType;

    @Column(name = "BUSINESS_IND")
    @Length(max = 3)
    private String businessIndication;

    @NotNull
    @Column(name = "REPOSITORY_ID")
    private Integer repositoryId;

    @NotNull
    @Column(name = "REPO_FIN_STMT_ID")
    private Short repoFinStmtId;

    @Column(name = "REMARK")
    @Length(max = 255)
    private String remark;
}
