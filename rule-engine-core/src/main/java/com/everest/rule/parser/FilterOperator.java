package com.everest.rule.parser;

public enum FilterOperator {
    EQUALS("="), NOT_EQUALS("<>"), GREATER_THAN(">"), GREAT_THAN_OR_EQUALS(">="), IN("in"), LESS_THAN("<"), LESS_THAN_OR_EQUALS("<="), LIKE("like"), HAS("has");
    
    private String operator;
    
    private FilterOperator(String operator) {
        this.operator = operator;
    }
    
    public String getOperator() {
        return this.operator;
    }

}
