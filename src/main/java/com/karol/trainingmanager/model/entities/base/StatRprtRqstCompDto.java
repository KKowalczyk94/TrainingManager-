package com.karol.trainingmanager.model.entities.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StatRprtRqstCompDto {
    private Long companyId;
    private String companyName;
}
