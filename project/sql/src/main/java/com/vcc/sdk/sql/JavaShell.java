package com.vcc.sdk.sql;

import com.vcc.sdk.sql.mapper.MapperCore;
import com.vcc.sdk.sql.md.SqlMdUtil;

import com.vcc.sdk.utils.StringUtil;
import com.vcc.sdk.utils.YmlUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;


public class JavaShell {
    
    private String filePath ;
    private String packageName ;
    private List<TableInfo> list = new ArrayList<>();
    private TableInfo tableInfo = null ;
    private YmlUtils ymlUtils ;
    
    public JavaShell(){
        String path = JavaShell.class.getClassLoader().getResource("mapper.yml").getPath();
        this.ymlUtils = new YmlUtils(path);
        start();
    }
    
    public Object getResource(){
        return this.getClass().getClassLoader();
    }
    
    public JavaShell(String path){
        /** 默认加载 */
        String pt = JavaShell.class.getClassLoader().getResource("mapper.yml").getPath();
        this.ymlUtils = new YmlUtils(pt);
        /** 设置加载指定项 */
        this.ymlUtils.setPath(path);
        this.ymlUtils.parseYML();
        start();
    }
    
    public void start(){
        String[] split = this.ymlUtils.getValueWithKey("mapper.dao",String.class).split("\\.");
        String file = "src/main/java/" ;
        for (int i = 0; i < split.length; i++) {
            file =  file + split[i] + "/";
        }
        this.filePath = file ;
        this.packageName = this.ymlUtils.getValueWithKey("mapper.dao",String.class) ;
        this.getPathContent();
    }
    
    /** mapper文件创建 */
    public void createMapperXML(){
        MapperCore mapperCore = new MapperCore(this.ymlUtils);
        mapperCore.setList(this.list);
        mapperCore.createMapper();
    }
    /** 创建 md 文件 */
    public void createSqlMd(){
        SqlMdUtil sqlMdUtil = new SqlMdUtil(this.list);
        sqlMdUtil.start(this.ymlUtils.getValueWithKey("mapper.md",String.class));
    }
    
    /** 生成 java文件 */
    public void createJavaFile(){
        for(TableInfo info:this.list){
            createJavaFile(info);    
        }
    }
    
    private void createJavaFile(TableInfo tableInfo){
        
        File file = new File(this.filePath+tableInfo.getTableName()+".java");
        if (file.exists() && file.isFile()){
            file.delete() ;
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()){
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null ;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(("package "+this.packageName+";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/**"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("@author vcc"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("@date "+new Date().toString()+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("*/"+ StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((tableInfo.getPackageListString()+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/** "+tableInfo.getTableComment()+" */"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("public class " + tableInfo.getTableName()+" implements java.io.Serializable"+"{"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       private static final long serialVersionUID = 1L;"+StringUtil.LINK_BREAKE).getBytes());
            
//            implements java.io.Serializable
            fileOutputStream.write((StringUtil.LINK_BREAKE.getBytes()));
            for(TableModel model:tableInfo.getFieldInfoList()){
                fileOutputStream.write(("    /** "+model.getComment()+"*/"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("    private "+model.getDataTypeJava()+" "+model.getFieldNameJava()+";"+StringUtil.LINK_BREAKE).getBytes());
            }
            addGetterAndSetter(fileOutputStream,tableInfo);
            fileOutputStream.write(("}"+StringUtil.LINK_BREAKE).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                fileOutputStream.close();
            }catch (IOException e){
                System.out.println("finally "+e);
            }
        }

    }
    
    private void addGetterAndSetter(FileOutputStream fileOutputStream,TableInfo info){
        
        for (TableModel model:info.getFieldInfoList()){
            try {
                fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("    /** "+model.getComment()+"*/"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("    public "+model.getDataTypeJava()+" get"+ StringUtil.upperFirstLatter(model.getFieldNameJava())+"(){"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("        return "+model.getFieldNameJava()+";"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("    }"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("    /** "+model.getComment()+"*/"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("    public void set"+StringUtil.upperFirstLatter(model.getFieldNameJava())+"("+model.getDataTypeJava()+" "+model.getFieldNameJava()+
                        "){"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("        this."+model.getFieldNameJava()+" = "+model.getFieldNameJava()+";"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("    }"+StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    
    
    /** 解析 sql 为 model 模型  */
    private void getPathContent(){
        File file = new File(this.ymlUtils.getValueWithKey("mapper.sql",String.class));
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String string = "";
            while (true){
                try {
                    if (!((string = bufferedReader.readLine()) != null)) {
                        break;
                    }else{
                        GenerateModelFromSql(string);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void GenerateModelFromSql(String sql){
        
        if (sql.trim().indexOf("CREATE TABLE") != -1){
            this.tableInfo = new TableInfo();
            tableInfo.setPackageName(this.packageName);
            String tableName = parseGetTable(sql);
            String s = StringUtil.parseCharacter(tableName,true);
            tableInfo.setTableName(s);
            tableInfo.setTableNameDB(tableName);
        }else if(sql.trim().indexOf("ENGINE") != -1){
            if (sql.indexOf("COMMENT") != -1){
                String substring = sql.substring(sql.indexOf("'"), sql.lastIndexOf("'"));
                this.tableInfo.setTableComment(substring);
            }
            this.tableInfo.reloadTableInfo();
            this.list.add(this.tableInfo);
        }else if(sql.trim().indexOf("COMMENT") != -1 || sql.trim().indexOf("DEFAULT") != -1 || sql.trim().indexOf( "NOT NULL" ) != -1){
            parseComment(sql);
        }else if(sql.trim().indexOf("PRIMARY") != -1){
            List<String> strings = StringUtil.parseString(sql, "`\\w+`");
            if (strings.size()>0){
                String s = strings.get(0);
                String substring = s.substring(1, s.lastIndexOf("`"));
                tableInfo.setPrimaryKey(substring);
            }
        }
    }
    
    
    private String parseGetTable(String sql){
        return sql.replaceFirst("CREATE", "").replace("`","").replaceFirst("TABLE", "").replaceFirst("\\(", "").trim().toLowerCase();
    }
    
    private void parseComment(String sql){
        String replace = sql.replace("`", "").replace("'", "");
        String s = StringUtil.parLineFrontBlank(replace);
        String key = s.substring(0,s.indexOf(" "));
        TableModel tableModel = new TableModel();
        tableModel.setFieldNameDB(key);
        tableModel.setFieldNameJava(StringUtil.parseCharacter(key,false));
        tableInfo.addFieldInfo(tableModel);
        String[] comments = s.split("COMMENT");
        if (comments.length>1){
            String comment = comments[1];
            tableModel.setComment(comment);
        }
        String string = StringUtil.parLineFrontBlank(s.substring(s.indexOf(" ")));
        String substring = string.substring(0, string.indexOf(" "));
        // 去掉数据类型后面的括号内容
        if (substring.indexOf("decimal") != -1){
            substring = substring.substring(0, substring.indexOf("("));
        }
        if (substring.trim().endsWith(")")) {
            substring = substring.substring(0, substring.indexOf("("));
        }
        if(substring.equals( "int" )){
            substring = "integer";
        }
        tableModel.setDataTypesql(substring);
    }
   
    
    
    
    
    
}
