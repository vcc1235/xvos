package com.vcc.sdk.sql.md;

import com.vcc.sdk.sql.TableInfo;
import com.vcc.sdk.sql.TableModel;
import com.vcc.sdk.utils.StringUtil;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class SqlMdUtil {
    
    private List<TableInfo> list ;
 
    
    public SqlMdUtil(List<TableInfo> list){
        this.list = list ;
    }
    
    public void start(String path){
        File file = new File(path);
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
            fileOutputStream.write(("### mall"+ StringUtil.LINK_BREAKE).getBytes());
            for (TableInfo info:this.list) {
                fileOutputStream.write((" - "+info.getTableNameDB() + " --- **"+ info.getTableComment()+"**"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write((" | 字段名 | 数据类型 | 描述 |"+"\n").getBytes());
                fileOutputStream.write((" | ------ | -------- | ------ |"+"\n").getBytes());
                for (TableModel model:info.getFieldInfoList()) {
                    fileOutputStream.write((" | "+model.getFieldNameDB()+" | "+model.getDataTypesql()+" | "+model.getComment()+" |"+
                            "\n").getBytes());
                }
            }
            
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
    
    
    
}
