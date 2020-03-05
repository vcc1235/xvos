package com.vcc.sdk.sql;



import java.util.ArrayList;
import java.util.List;

public class TableInfo {
    
    private String tableName = "";
    
    private String tableNameDB ;
    
    private String primaryKey ;
    
    private String packageName ;
    
    private String tableComment ;
    
    private String packageListString = "";
    
    private List<TableModel> fieldInfoList ;

    public TableInfo(){
        this.fieldInfoList = new ArrayList<>();
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTableNameDB() {
        return tableNameDB;
    }

    public void setTableNameDB(String tableNameDB) {
        this.tableNameDB = tableNameDB;
    }

    public String getTableName() {
        return tableName;
    }

    public String getPackageListString() {
        return packageListString;
    }

    public void setPackageListString(String packageListString) {
        this.packageListString = packageListString;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<TableModel> getFieldInfoList() {
        return fieldInfoList;
    }

    public void setFieldInfoList(List<TableModel> fieldInfoList) {
        this.fieldInfoList = fieldInfoList;
    }
    
    public void addFieldInfo(TableModel info){
        this.fieldInfoList.add(info);
    }
    
    public void reloadTableInfo(){
        for (TableModel model : this.fieldInfoList){
            String type = SQLDataType.mappingSqlDataType(model.getDataTypesql());
            model.setDataTypeJava(type);
            if (type.indexOf("Timestamp") != -1 && this.packageListString.indexOf("java.sql.Timestamp")==-1){
                this.packageListString = this.packageListString +"import java.sql.Timestamp;"+"\r\n" ;
            }else if(type.indexOf("BigDecimal") != -1 && this.packageListString.indexOf("java.math.BigDecimal")==-1){
                this.packageListString = this.packageListString +"import java.math.BigDecimal;\r\n";
            }else if(type.indexOf("Date") != -1 && this.packageListString.indexOf("java.util.Date")==-1){
                this.packageListString = this.packageListString +"import java.util.Date;\r\n";
            }else if(type.indexOf("Time") != -1 && this.packageListString.indexOf("java.sql.Time")==-1){
                this.packageListString = this.packageListString +"import java.sql.Time;\r\n";
            }
        }
    }
    
    public TableModel getTableModel(String column){
        for (TableModel model:this.getFieldInfoList()) {
            if (model.getFieldNameDB().trim().equals(column.trim())){
                return model ;
            }
        }
        return null ;
    }
    
    
}
