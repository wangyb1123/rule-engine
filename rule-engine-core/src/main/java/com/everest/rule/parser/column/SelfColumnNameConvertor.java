package com.everest.rule.parser.column;

public class SelfColumnNameConvertor implements ColumnNameConvertor {

    @Override
    public String convert(String column) {
        return ColumnNameConvertor.extractColumn(column);
    }

}
