package com.vcc.sdk.sql.mapper;

public class MapperOpionModel {
    
    private String name = "";
    private String property = "" ;
    private String ignor = "" ;
    private String type  = "" ;
    private String result = "" ;
    private Boolean run = false ;


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getRun() {
        return run;
    }

    public void setRun(Boolean run) {
        this.run = run;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getIgnor() {
        return ignor;
    }

    public void setIgnor(String ignor) {
        this.ignor = ignor;
    }
}
