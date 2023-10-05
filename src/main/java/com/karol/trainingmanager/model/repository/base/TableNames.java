package com.karol.trainingmanager.model.repository.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TableNames {
    REQUEST_SUBMISSION("STAT_RPRT_SBMT"), RIGLSTMT("RIGLSTMT");

    private final String tableName;

    public static TableNames getByTableField(String tableName) {
        return Stream.of(TableNames.values()).filter(item -> tableName.equals(item.getTableName()))
                .findFirst().get();
    }
}
