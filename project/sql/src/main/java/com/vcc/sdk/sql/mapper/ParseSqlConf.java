package com.vcc.sdk.sql.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseSqlConf {
    
    private MapperModel tableModel ;
    private List<MapperModel> mapperModelList = new ArrayList<>();
    private HashMap<String,Integer> hashMap = new HashMap<>();
    
    private MapperModel mapperModel = null ;
    
    public ParseSqlConf(Map<String, HashMap<String, Object>> map){
        start(map);
    }
    
    private void start(Map<String, HashMap<String, Object>> map)  {
        HashMap<String, Object> table = map.get("table");
        this.tableModel = new MapperModel();
        this.tableModel.setTableName("*");
        for (String string:table.keySet()) {
            MapperModel mapperModel = new MapperModel();
            mapperModel.setOptionString(string);
            try{
                HashMap<String, Object> stringObjectHashMap = (HashMap<String, Object>) table.get(string);
                optionString(stringObjectHashMap,mapperModel);
            }catch (Exception e){
                System.out.println(e.getMessage());   
            }
            this.tableModel.getMapperModelList().add(mapperModel);
        }
        Integer index = 0 ;
        for (String keyString:map.keySet()) {
            if (keyString.equals("table") || keyString.equals("mapper")){continue; }
            HashMap<String, Object> stringObjectHashMap = map.get(keyString);
            MapperModel mapperModel = new MapperModel();
            mapperModel.setTableName(keyString);
            for (String option:stringObjectHashMap.keySet()) {
                MapperModel mapperModel1 = new MapperModel();
                mapperModel1.setOptionString(option);
                try{
                    Map<String, Object> stringObjectMap = (Map<String, Object>) stringObjectHashMap.get(option);
                    optionString(stringObjectMap,mapperModel1);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                mapperModel.getMapperModelList().add(mapperModel1);
            }
            this.mapperModelList.add(mapperModel);
            this.hashMap.put(keyString,index);
            index++; 
        }
    }
    
    private void optionString(Map<String,Object> map,MapperModel mapperModel){

        for (String key: map.keySet()) {
            MapperOpionModel mapperOpionModel = new MapperOpionModel();
            mapperOpionModel.setName(key);
            HashMap<String, String> stringStringHashMap = (HashMap<String, String>) map.get(key);
            for (String string: stringStringHashMap.keySet()) {
                if (string.equals("property")){
                    mapperOpionModel.setProperty(stringStringHashMap.get(string));
                }else if(string.equals("ignor")){
                    mapperOpionModel.setIgnor(stringStringHashMap.get(string));
                }else if(string.equals("run")){
                    mapperOpionModel.setRun(Boolean.parseBoolean(stringStringHashMap.get(string).trim()));
                }else if(string.equals("type")){
                    mapperOpionModel.setType(stringStringHashMap.get(string));
                }else if(string.equals("result")){
                    mapperOpionModel.setResult(stringStringHashMap.get(string));
                }
            }
            mapperModel.getMapperOpionModels().add(mapperOpionModel);
        }
        
    }


    public MapperModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(MapperModel tableModel) {
        this.tableModel = tableModel;
    }

    public List<MapperModel> getMapperModelList() {
        return mapperModelList;
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public void setMapperModelList(List<MapperModel> mapperModelList) {
        this.mapperModelList = mapperModelList;
    
    }
    
}
