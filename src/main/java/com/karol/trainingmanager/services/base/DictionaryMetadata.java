package com.karol.trainingmanager.services.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DictionaryMetadata {
    private String valCode;
    private String valMeaning;
}
