package com.karol.trainingmanager.model.repository.base;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Reflections {
    String getTableName(Class object) {
        return ((Table) object.getAnnotation(Table.class)).name();
    }

    String getJoinedColumnName(Class object) {
        // TODO: implement to upper
        // TODO: handle different ID (another then ID or JoinColumn)
        return object.isAnnotationPresent(JoinColumn.class) ?
                ((JoinColumn) object.getAnnotation(JoinColumn.class)).name()
                : "ID";
    }
}

