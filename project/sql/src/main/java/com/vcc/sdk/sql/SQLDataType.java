package com.vcc.sdk.sql;

import java.util.HashMap;
import java.util.Map;

public class SQLDataType {
    
    public final static Map<String,String> MYSQL_DATA_TYPE_VARCHAR = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_VARCHAR.put("varchar","varchar");
        MYSQL_DATA_TYPE_VARCHAR.put("json","json");
        MYSQL_DATA_TYPE_VARCHAR.put("text","text");
        MYSQL_DATA_TYPE_VARCHAR.put("char","char");
        MYSQL_DATA_TYPE_VARCHAR.put("enum","enum");
        MYSQL_DATA_TYPE_VARCHAR.put("longtext","longtext");
        MYSQL_DATA_TYPE_VARCHAR.put("mediumtext","mediumtext");
        MYSQL_DATA_TYPE_VARCHAR.put("set","set");
        MYSQL_DATA_TYPE_VARCHAR.put("tinytext","tinytext");
        
    }
    public final static Map<String,String> MYSQL_DATA_TYPE_INT = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_INT.put("int","int");
        MYSQL_DATA_TYPE_INT.put("bit","bit");
        MYSQL_DATA_TYPE_INT.put("integer","integer");
        MYSQL_DATA_TYPE_INT.put("mediumint","mediumint");
        MYSQL_DATA_TYPE_INT.put("smallint","smallint");
        
    }
    public final static Map<String,String> MYSQL_DATA_TYPE_DOUBLE = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_DOUBLE.put("double","double");
    }
    public final static Map<String,String> MYSQL_DATA_TYPE_FLOAT = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_FLOAT.put("float","float");
    }
    public final static Map<String,String> MYSQL_DATA_TYPE_BOOLEAN = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_BOOLEAN.put("tinyint","tinyint");
    }
    public final static Map<String,String> MYSQL_DATA_TYPE_LONG = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_LONG.put("long","long");
        MYSQL_DATA_TYPE_LONG.put("bigint","bigint");
    }
    public final static Map<String,String> MYSQL_DATA_TYPE_DECIMAL = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_DECIMAL.put("decimal","decimal");
    }
    public final static Map<String,String> MYSQL_DATA_TYPE_DATE = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_DATE.put("date","date");
        MYSQL_DATA_TYPE_DATE.put("year","year");
    } 
    public final static Map<String,String> MYSQL_DATA_TYPE_TIME = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_TIME.put("time","time");
    }
    
    public final static Map<String,String> MYSQL_DATA_TYPE_TIMESTAMP = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_TIMESTAMP.put("datetime","datetime");
        MYSQL_DATA_TYPE_TIMESTAMP.put("timestamp","timestamp");
    }
    public final static Map<String,String> MYSQL_DATA_TYPE_BYTE = new HashMap<>();
    static {
        MYSQL_DATA_TYPE_BYTE.put("bit","bit");
        MYSQL_DATA_TYPE_BYTE.put("blob","blob");
        MYSQL_DATA_TYPE_BYTE.put("longblob","longblob");
        MYSQL_DATA_TYPE_BYTE.put("mediumblob","mediumblob");
        MYSQL_DATA_TYPE_BYTE.put("tinyblob","tinyblob");
        MYSQL_DATA_TYPE_BYTE.put("varbinary","varbinary");
    }
    
    
    public static String mappingSqlDataType(String type){
        
        if (MYSQL_DATA_TYPE_DATE.containsValue(type.toLowerCase())){
            return "Date" ;
        }else if(MYSQL_DATA_TYPE_INT.containsValue(type.toLowerCase())){
            return "Integer" ;
        }else if(MYSQL_DATA_TYPE_LONG.containsValue(type.toLowerCase())){
            return "Long" ;
        }else if(MYSQL_DATA_TYPE_VARCHAR.containsValue(type.toLowerCase())){
            return "String" ;
        }else if(MYSQL_DATA_TYPE_DECIMAL.containsValue(type.toLowerCase())){
            return "BigDecimal";
        }else if(MYSQL_DATA_TYPE_BOOLEAN.containsValue(type.toLowerCase())){
            return "boolean";
        }else if(MYSQL_DATA_TYPE_BYTE.containsValue(type.toLowerCase())){
            return "byte[]";
        }else if(MYSQL_DATA_TYPE_TIMESTAMP.containsValue(type.toLowerCase())){
            return "Timestamp";
        }else if(MYSQL_DATA_TYPE_DOUBLE.containsValue(type.toLowerCase())){
            return "Double";
        }else if(MYSQL_DATA_TYPE_FLOAT.containsValue(type.toLowerCase())){
            return "Float";
        }else if(MYSQL_DATA_TYPE_TIME.containsValue(type.toLowerCase())){
            return "Time";
        }
        return "";
    }
    
}
