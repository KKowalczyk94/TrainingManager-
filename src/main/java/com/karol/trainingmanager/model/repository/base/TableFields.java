package com.karol.trainingmanager.model.repository.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TableFields {
    ID("ID"), STATUS("STATUS"), GL_FIN_STMT_NAME("GL_FIN_STMT_NAME"), GL_FIN_STMT_ID("GL_FIN_STMT_ID");

    private final String tableField;

    public static TableFields getByTableField(String tableField) {
        return Stream.of(TableFields.values()).filter(item -> tableField.equals(item.getTableField()))
                .findFirst().get();
    }
}
