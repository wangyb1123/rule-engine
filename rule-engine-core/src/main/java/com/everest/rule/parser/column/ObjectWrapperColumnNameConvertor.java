package com.everest.rule.parser.column;

import com.everest.rule.wrapper.ObjectWrapper;

public class ObjectWrapperColumnNameConvertor implements ColumnNameConvertor {

    @Override
    public String convert(String column) {
        if(column.startsWith(REFDATA_INDICATOR)){
            return ColumnNameConvertor.extractColumn(column);
        }else{
            return ObjectWrapper.OBJECT_NAME + "." + ColumnNameConvertor.extractColumn(column);
        }
    }

}
