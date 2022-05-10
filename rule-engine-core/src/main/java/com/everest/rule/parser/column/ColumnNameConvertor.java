package com.everest.rule.parser.column;

public interface ColumnNameConvertor {
    public static final String REFDATA_INDICATOR = "#";
    
    String convert(String column);
    
    public static String extractColumn(String column) {
        if(column.startsWith(REFDATA_INDICATOR)&&column.endsWith(REFDATA_INDICATOR)) {
            return column.substring(1, column.lastIndexOf(REFDATA_INDICATOR));
        }
        return column;
    }
}
