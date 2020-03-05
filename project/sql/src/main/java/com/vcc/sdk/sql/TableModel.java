package com.vcc.sdk.sql;

public class TableModel {
    
    private String fieldNameDB ;
    
    private String fieldNameJava ;
    
    private String dataTypesql ;
    
    private String dataTypeJava ;
    
    private String comment ;

    public String getFieldNameDB() {
        return fieldNameDB;
    }

    public void setFieldNameDB(String fieldNameDB) {
        this.fieldNameDB = fieldNameDB;
    }

    public String getFieldNameJava() {
        return fieldNameJava;
    }

    public void setFieldNameJava(String fieldNameJava) {
        this.fieldNameJava = fieldNameJava;
    }

    public String getDataTypesql() {
        return dataTypesql;
    }

    public void setDataTypesql(String dataTypesql) {
        this.dataTypesql = dataTypesql;
    }

    public String getDataTypeJava() {
        return dataTypeJava;
    }

    public void setDataTypeJava(String dataTypeJava) {
        this.dataTypeJava = dataTypeJava;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
