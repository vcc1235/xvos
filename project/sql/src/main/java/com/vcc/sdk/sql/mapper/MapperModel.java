package com.vcc.sdk.sql.mapper;



import java.util.ArrayList;
import java.util.List;

public class MapperModel {
    
    /** 操作 */
    private String optionString ;
    private String tableName ;
    private List<MapperOpionModel> mapperOpionModels = new ArrayList<>();
    private List<MapperModel> mapperModelList = new ArrayList<>();

    public List<MapperModel> getMapperModelList() {
        return mapperModelList;
    }

    public void setMapperModelList(List<MapperModel> mapperModelList) {
        this.mapperModelList = mapperModelList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getOptionString() {
        return optionString;
    }

    public void setOptionString(String optionString) {
        this.optionString = optionString;
    }

    public List<MapperOpionModel> getMapperOpionModels() {
        return mapperOpionModels;
    }

    public void setMapperOpionModels(List<MapperOpionModel> mapperOpionModels) {
        this.mapperOpionModels = mapperOpionModels;
    }
}
