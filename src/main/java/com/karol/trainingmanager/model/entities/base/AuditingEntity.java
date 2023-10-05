package com.karol.trainingmanager.model.entities.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class AuditingEntity {
    @Column(name = "DISCONTINUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date discontinueDate;

    @Column(name = "UPDATE_DATE")
    //@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Column(name = "USER_IDENTITY", columnDefinition = "char")
    @Length(max = 8)
    private String userIdentity;
}

