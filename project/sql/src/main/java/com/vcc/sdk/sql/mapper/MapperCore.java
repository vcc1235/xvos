package com.vcc.sdk.sql.mapper;

import com.vcc.sdk.sql.TableInfo;
import com.vcc.sdk.sql.TableModel;
import com.vcc.sdk.utils.StringUtil;
import com.vcc.sdk.utils.YmlUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class MapperCore {
    
    private String domain ;
    private String mapperPath ;
    private String packageMapper;
    private List<TableInfo> list ;
    private ParseSqlConf parseSqlConf ;
    
    public List<TableInfo> getList() {
        return list;
    }

    public void setList(List<TableInfo> list) {
        this.list = list;
    }

    public MapperCore(YmlUtils ymlUtils){
        this.mapperPath = ymlUtils.getValueWithKey("mapper.mapperxml",String.class) ;
        this.packageMapper = ymlUtils.getValueWithKey("mapper.mapper",String.class) ;
        this.domain = ymlUtils.getValueWithKey("mapper.dao",String.class);
        this.parseSqlConf = new ParseSqlConf(ymlUtils.getMap());
    }
        
    public  void  createMapper(){
        for (TableInfo tableInfo:this.list) {
            createMapper(tableInfo);
            createMapperIServiceFile(tableInfo);
            createMapperIServiceImplFile(tableInfo);
        }
        /** 创建公共mapper*/
        createMapperOpreation();
        
        createMapperIService();
        
        createMapperAbstractIService();
        
        createMapperFile();
        
        
        
    } 
    
    
    private void createMapperFile(){
        for (TableInfo tableInfo:this.list) {
            createMapperFile(tableInfo);
        }
    }
    
    private void createMapperFile(TableInfo tableInfo) {
        String[] split1 = this.packageMapper.split("\\.");
        String path = "src/main/java/";
        String packageName = "";
        for (int i = 0; i < split1.length; i++) {
            path = path + split1[i] + "/";
            if (i != split1.length-1){
                packageName+=split1[i]+".";
            }
        }
        packageName+="common";
        File file = new File(path +"I"+StringUtil.upperFirstLatter(tableInfo.getTableName())+"Mapper.java");
        if (file.exists() && file.isFile()) {
            return; 
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(("package "+this.packageMapper+";"+ StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+packageName+".IOperations;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+this.domain+"."+tableInfo.getTableName()+";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/**\n" +
                    " * @author 123\n" +
                    " */"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("public interface I"+tableInfo.getTableName()+"Mapper extends IOperations<"+tableInfo.getTableName()+"> {").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+"}").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createMapperIServiceFile(TableInfo tableInfo) {
        String[] split1 = this.packageMapper.split("\\.");
        String path = "src/main/java/";
        String packageName = "";
  
        for (int i = 0; i < split1.length-1; i++) {
            path = path + split1[i] + "/";
            packageName+=split1[i]+".";
  
            
        }
    
        File file = new File(path+"service/"+"I"+StringUtil.upperFirstLatter(tableInfo.getTableName())+"Service.java");
        if (file.exists() && file.isFile()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(("package "+packageName+"service"+";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+packageName+"common.IServiceOperations;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+this.domain+"."+tableInfo.getTableName()+";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/**\n" +
                    " * @author 123\n" +
                    " */"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("public interface I"+tableInfo.getTableName()+"Service extends IServiceOperations<"+tableInfo.getTableName()+"> {").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+"}").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createMapperIServiceImplFile(TableInfo tableInfo) {
        String[] split1 = this.packageMapper.split("\\.");
        String path = "src/main/java/";
        String packageName = "";

        for (int i = 0; i < split1.length-1; i++) {
            path = path + split1[i] + "/";
            packageName+=split1[i]+".";
        }

        File file = new File(path+"service/impl/"+StringUtil.upperFirstLatter(tableInfo.getTableName())+"Service" +
                ".java");
        if (file.exists() && file.isFile()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(("package "+packageName+"service.impl"+";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+packageName+"common.AbstractService;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+this.domain+"."+tableInfo.getTableName()+";"+StringUtil.LINK_BREAKE).getBytes());
//            import org.springframework.stereotype.Service;
//import com.plan.common.AbstractService;
//import com.plan.common.IOperations;
//import com.plan.plan.mapper.ICatMapper;
//import com.plan.plan.domain.Cat;
//import com.plan.plan.service.ICatService;
            fileOutputStream.write(("import org.springframework.stereotype.Service;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+this.packageMapper+".I"+StringUtil.upperFirstLatter(tableInfo.getTableName())+"Mapper;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+packageName+"common.IOperations;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import javax.annotation.Resource;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import "+packageName+"service.I"+StringUtil.upperFirstLatter(tableInfo.getTableName())+"Service;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/**\n" +
                    " * @author 123\n" +
                    " */"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("@Service(\""+tableInfo.getTableName()+"\")"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("public class "+tableInfo.getTableName()+"Service extends AbstractService<"+tableInfo.getTableName()+"> implements I"+StringUtil.upperFirstLatter(tableInfo.getTableName())+"Service{").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       public "+tableInfo.getTableName()+"Service(){").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("           this.setTableName(\""+tableInfo.getTableNameDB()+"\");").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+"        }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       @Resource"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       private I"+tableInfo.getTableName()+"Mapper "+StringUtil.lowerFirstLatter(tableInfo.getTableName())+
                    "Mapper;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       protected IOperations<"+tableInfo.getTableName()+"> getMapper(){"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("           return "+StringUtil.lowerFirstLatter(tableInfo.getTableName())+
                    "Mapper;").getBytes());
            fileOutputStream.write(("       }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       public void setTableName(String tableName){").getBytes());
            fileOutputStream.write(("           this.tableName=tableName;}").getBytes());
            fileOutputStream.write(("").getBytes());
            fileOutputStream.write(("").getBytes());
            fileOutputStream.write(("").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+"}").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






















    public void  createMapperOpreation(){
        String[] split1 = this.packageMapper.split("\\.");
        String path = "src/main/java/";
        String packageName = "";
        for (int i = 0; i < split1.length-1; i++) {
            path = path + split1[i] + "/";
            packageName+=split1[i]+".";
        }
        File file = new File(path+"common/IOperations.java");
        packageName+="common";
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

            fileOutputStream.write(("package "+packageName+";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.util.LinkedHashMap;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.io.Serializable;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.util.List;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import org.apache.ibatis.annotations.Param;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/**\n" +
                    " * @author 123\n" +
                    " */"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("public interface IOperations<T extends Serializable> {").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            for (MapperModel mapperModel:this.parseSqlConf.getTableModel().getMapperModelList()) {
                if (mapperModel.getOptionString().equals("insert")){
                    insert(mapperModel,fileOutputStream);
                }else if(mapperModel.getOptionString().equals("select")){
                    select(mapperModel,fileOutputStream);
                }else if(mapperModel.getOptionString().equals("update")){
                    update(mapperModel,fileOutputStream,false);
                    update(mapperModel,fileOutputStream,true);
                }
            }
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

    public void  createMapperIService(){
        String[] split1 = this.packageMapper.split("\\.");
        String path = "src/main/java/";
        String packageName = "";
        for (int i = 0; i < split1.length-1; i++) {
            path = path + split1[i] + "/";
            packageName+=split1[i]+".";
        }
        File file = new File(path+"common/IServiceOperations.java");
        packageName+="common";
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

            fileOutputStream.write(("package "+packageName+";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.util.LinkedHashMap;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.io.Serializable;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.util.List;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/**\n" +
                    " * @author 123\n" +
                    " */"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("public interface IServiceOperations<T extends Serializable> extends IOperations<T> {").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            /** insert*/
            fileOutputStream.write(("   List<T> "+"getList"+"(String field, LinkedHashMap<String, String> condition," +
                    "int offset,int limit,String order)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   List<T> "+"getList"+"(LinkedHashMap<String, String> condition," +
                    "int offset,int limit,String order)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   List<T> "+"getList"+"(LinkedHashMap<String, String> condition," +
                    "int offset,int limit)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   List<T> "+"getAll"+"(String field, LinkedHashMap<String, String> condition)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   List<T> "+"getAll"+"(String field, LinkedHashMap<String, String> condition," +
                    "String order)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   List<T> "+"getAll"+"(LinkedHashMap<String, String> condition)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   List<T> "+"getAll"+"(LinkedHashMap<String, String> condition , String order)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   T "+"getOne"+"(LinkedHashMap<String, String> condition)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   Integer "+"getCount"+"(String field,LinkedHashMap<String, String> condition," +
                    "int offset,int limit)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   Integer "+"getCount"+"(String field,LinkedHashMap<String, String> condition)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   void "+"insertList"+"(List<T> list)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   void "+"insert"+"(final T entity)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());

//            int updateBatch(@Param("list") List<T> list,@Param("field") String field,@Param("condition") LinkedHashMap<String, String> condition,  @Param("tableName") String tableName);
//
//
//            int update(@Param("entity") final T entity, @Param("field") String field,@Param("condition") LinkedHashMap<String, String> condition,  @Param("tableName") String tableName);
            fileOutputStream.write(("   int "+"updateBatch"+"(List<T> list,String field,LinkedHashMap<String, " +
                    "String> condition)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   int "+"updateBatch"+"(List<T> list,LinkedHashMap<String, String> condition)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   int "+"updateBatch"+"(List<T> list)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   int "+"update"+"(final T entity,String field,LinkedHashMap<String, " +
                    "String> condition)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   int "+"update"+"(final T entity,LinkedHashMap<String, " +
                    "String> condition)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   int "+"update"+"(final T entity)" +
                    ";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            
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

    public void  createMapperAbstractIService(){
        String[] split1 = this.packageMapper.split("\\.");
        String path = "src/main/java/";
        String packageName = "";
        for (int i = 0; i < split1.length-1; i++) {
            path = path + split1[i] + "/";
            packageName+=split1[i]+".";
        }
        File file = new File(path+"common/AbstractService.java");
        packageName+="common";
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

            fileOutputStream.write(("package "+packageName+";"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.util.LinkedHashMap;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.io.Serializable;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("import java.util.List;"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/**\n" +
                    " * @author 123\n" +
                    " */"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("public abstract class AbstractService<T extends Serializable> implements IServiceOperations<T> {").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   protected abstract IOperations<T> getMapper();").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   protected String tableName = \"\";").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public abstract void setTableName(String tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   protected String getTableName() { return this.tableName;}").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            /** insert*/
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public List<T> "+"getList"+"(String field, LinkedHashMap<String, String> " +
                    "condition," +
                    "int offset,int limit,String order) {" +StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getAll(field,condition,offset,limit,order," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public List<T> "+"getList"+"(LinkedHashMap<String, String> condition," +
                    "int offset,int limit,String order){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getAll(null,condition,offset,limit,order," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public List<T> "+"getList"+"(LinkedHashMap<String, String> condition," +
                    "int offset,int limit){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getAll(null,condition,offset,limit,null," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public List<T> "+"getAll"+"(String field, LinkedHashMap<String, String> " +
                    "condition){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getAll(field,condition,0,0,null," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public List<T> "+"getAll"+"(String field, LinkedHashMap<String, String> " +
                    "condition," +
                    "String order){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getAll(field,condition,0,0,order," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public List<T> "+"getAll"+"(LinkedHashMap<String, String> condition){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getAll(null,condition,0,0,null," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public List<T> "+"getAll"+"(LinkedHashMap<String, String> condition , String " +
                    "order){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getAll(null,condition,0,0,order," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public T "+"getOne"+"(LinkedHashMap<String, String> condition){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       List<T> list = this.getAll(null,condition,0,1,null," +
                    "tableName);").getBytes());
            fileOutputStream.write(("       if(list != null && list.size()>0){return list.get(0);} "+StringUtil.LINK_BREAKE+"           " +
                    "return " +
                    "null;").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public Integer "+"getCount"+"(String field,LinkedHashMap<String, String> " +
                    "condition," +
                    "int offset,int limit){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getCount(field,condition,offset,limit,null," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public Integer "+"getCount"+"(String field,LinkedHashMap<String, String> " +
                    "condition){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.getCount(field,condition,0,0,null," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public void "+"insertList"+"(List<T> list){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("        this.insertList(list," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public void "+"insert"+"(final T entity){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("        this.insertTo(entity," +
                    "tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());

//            int updateBatch(@Param("list") List<T> list,@Param("field") String field,@Param("condition") LinkedHashMap<String, String> condition,  @Param("tableName") String tableName);
//
//
//            int update(@Param("entity") final T entity, @Param("field") String field,@Param("condition") LinkedHashMap<String, String> condition,  @Param("tableName") String tableName);
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public int "+"updateBatch"+"(List<T> list,String field,LinkedHashMap<String," +
                    " " +
                    "String> condition){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.updateBatch(list,field,condition,tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public int "+"updateBatch"+"(List<T> list,LinkedHashMap<String, String> " +
                    "condition){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.updateBatch(list,null,condition,tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public int "+"updateBatch"+"(List<T> list){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.updateBatchById(list,null,tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public int "+"update"+"(final T entity,String field,LinkedHashMap<String, " +
                    "String> condition){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.update(entity,field,condition,tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public int "+"update"+"(final T entity,LinkedHashMap<String, " +
                    "String> condition){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.update(entity,null,condition,tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   public int "+"update"+"(final T entity){" + StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       return this.updateById(entity,null,tableName);").getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("   }"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("/** 下面为内部方式无需调用 可以根据下面方法自定义新的 */"+StringUtil.LINK_BREAKE).getBytes());
            for (MapperModel mapperModel:this.parseSqlConf.getTableModel().getMapperModelList()) {
                if (mapperModel.getOptionString().equals("insert")){
                    insertService(mapperModel,fileOutputStream);
                }else if(mapperModel.getOptionString().equals("select")){
                    selectService(mapperModel,fileOutputStream);
                }else if(mapperModel.getOptionString().equals("update")){
                    updateService(mapperModel,fileOutputStream,false);
                    updateService(mapperModel,fileOutputStream,true);
                }
            }
            
//            @Override
//            public List<T> getAll(String field, LinkedHashMap<String, String> condition, int offset, int limit, String order, String tableName) {
//                return this.getMapper().getAll(field, condition, offset, limit, order, tableName);
//            }
//
//            @Override
//            public Integer getCount(String field, LinkedHashMap<String, String> condition, int offset, int limit, String order, String tableName) {
//                return this.getMapper().getCount(field, condition, offset, limit, order, tableName);
//            }
//
//            @Override
//            public void insertList(List<T> list, String tableName) {
//                this.getMapper().insertList(list, tableName);
//            }
//
//            @Override
//            public void insertTo(T entity, String tableName) {
//                this.getMapper().insertTo(entity, tableName);
//            }
//
//            @Override
//            public int updateBatch(List<T> list, String field, LinkedHashMap<String, String> condition, String tableName) {
//                return this.getMapper().updateBatch(list, field, condition, tableName);
//            }
//
//            @Override
//            public int update(T entity, String field, LinkedHashMap<String, String> condition, String tableName) {
//                return this.getMapper().update(entity, field, condition, tableName);
//            }
//
//            @Override
//            public int updateBatchById(List<T> list, String field, String tableName) {
//                return this.getMapper().updateBatchById(list, field, tableName);
//            }
//
//            @Override
//            public int updateById(T entity, String field, String tableName) {
//                return this.getMapper().updateById(entity, field, tableName);
//            }
            fileOutputStream.write((StringUtil.LINK_BREAKE+"}"+StringUtil.LINK_BREAKE).getBytes());
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
    
    public void insertService(MapperModel mapperModel , FileOutputStream fileOutputStream){
        for (MapperOpionModel opionModel: mapperModel.getMapperOpionModels()) {
                try {
                    if (opionModel.getRun()){
                        fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
                        fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
                        fileOutputStream.write(("   public void "+opionModel.getName()+"(List<T> list, String " +
                                "tableName){"+StringUtil.LINK_BREAKE).getBytes());
                        fileOutputStream.write(("       this.getMapper()."+opionModel.getName()+"(list,tableName);"+StringUtil.LINK_BREAKE).getBytes());
                        fileOutputStream.write(("   }").getBytes());
                    }else{
                        fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
                        fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
                        fileOutputStream.write(("   public void "+opionModel.getName()+"(final T entity, String " +
                                "tableName){"+StringUtil.LINK_BREAKE).getBytes());
                        fileOutputStream.write(("       this.getMapper()."+opionModel.getName()+"(entity,tableName);"+StringUtil.LINK_BREAKE).getBytes());
                        fileOutputStream.write(("   }").getBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    
    public void selectService(MapperModel mapperModel , FileOutputStream fileOutputStream){
        for (MapperOpionModel option:mapperModel.getMapperOpionModels()) {
            try {
                fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("   public "+(option.getResult().trim().length()==0?"List<T> ":
                        option.getResult()+" ")+option.getName()+"(" +
                        "String field," +
                        "LinkedHashMap<String, String> condition," +
                        "int offset , " +
                        "int limit," +
                        "String order," +
                        "String tableName){"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("      return this.getMapper()."+option.getName()+"(field,condition,offset," +
                        "limit,order,tableName);"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write(("   }").getBytes());
                fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public void updateService(MapperModel mapperModel , FileOutputStream fileOutputStream,boolean isKeyPrimary){
        for (MapperOpionModel option:mapperModel.getMapperOpionModels()) {
            try {
                if (option.getRun()){
                    fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
                    fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
                    fileOutputStream.write(("   public int "+option.getName()+(isKeyPrimary?"ById":"")+"(" +
                            "List<T> list," +
                            "String field," +
                            (isKeyPrimary?"":"LinkedHashMap<String, String> condition,")+
                            "String tableName){"+StringUtil.LINK_BREAKE).getBytes());
                    fileOutputStream.write(("      return this.getMapper()."+option.getName()+(isKeyPrimary?"ById":"")+"(list,field,"+(isKeyPrimary?"":"condition,") +
                            "tableName);"+StringUtil.LINK_BREAKE).getBytes());
                    fileOutputStream.write(("   }").getBytes());
                }else{
                    fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
                    fileOutputStream.write(("   @Override"+StringUtil.LINK_BREAKE).getBytes());
                    fileOutputStream.write(("   public int "+option.getName()+(isKeyPrimary?"ById":"")+"(" +
                            "final T entity, " +
                            "String field," +
                            (isKeyPrimary?"":"LinkedHashMap<String, String> condition, ")+
                            " String tableName){"+StringUtil.LINK_BREAKE).getBytes());
                    fileOutputStream.write(("      return this.getMapper()."+option.getName()+(isKeyPrimary?"ById":"")+"(entity,field,"+(isKeyPrimary?"":"condition,") +
                            "tableName);"+StringUtil.LINK_BREAKE).getBytes());
                    fileOutputStream.write(("   }").getBytes());
                }
                fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    
    
    
    public void insert(MapperModel mapperModel,FileOutputStream fileOutputStream ){

        for (MapperOpionModel option:mapperModel.getMapperOpionModels()) {

            try {
                if (option.getRun()){
                    fileOutputStream.write(("   void "+option.getName()+"(@Param(\"list\") List<T> list, @Param" +
                            "(\"tableName\") String tableName);"+StringUtil.LINK_BREAKE).getBytes());
                }else{
                    fileOutputStream.write(("   void "+option.getName()+"(@Param(\"entity\") final T entity, @Param" +
                            "(\"tableName\") String tableName);"+StringUtil.LINK_BREAKE).getBytes());
                }
                fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
    }
    //
//            T getById(@Param("id") final int id, @Param("tableName") String tableName);
//
//            T getOne(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);
//
//            int getCount(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);
//
//            List<T> getList(@Param("condition") LinkedHashMap<String, String> condition, @Param("offset") int offset, @Param("limit") int limit, @Param("order") String order,
//            @Param("field") String field, @Param("tableName") String tableName);
    public void select(MapperModel mapperModel,FileOutputStream fileOutputStream ){

        for (MapperOpionModel option:mapperModel.getMapperOpionModels()) {
            try {
                fileOutputStream.write(("   "+(option.getResult().trim().length()==0?"List<T> ":option.getResult()+" ")+option.getName()+"(" +
                        "@Param(\"field\") String field," +
                        "@Param(\"condition\") LinkedHashMap<String, String> condition," +
                        "@Param(\"offset\") int offset , " +
                        "@Param(\"limit\") int limit," + 
                        "@Param(\"order\") String order," + 
                        "@Param(\"tableName\") String tableName);"+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    //
//            int update(@Param("list") List<T> list, @Param("tableName") String tableName);
//
//            int updateByBatch(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);
    public void update(MapperModel mapperModel,FileOutputStream fileOutputStream,boolean isKeyPrimary){

        for (MapperOpionModel option:mapperModel.getMapperOpionModels()) {

            try {
                if (option.getRun()){
                    fileOutputStream.write(("   int "+option.getName()+(isKeyPrimary?"ById":"")+"(@Param(\"list\") " +
                            "List<T> " +
                            "list," +
                            "@Param(\"field\") String field," +
                            (isKeyPrimary?"":"@Param(\"condition\") LinkedHashMap<String, String> condition, ")+
                            " @Param" +
                            "(\"tableName\") String tableName);"+StringUtil.LINK_BREAKE).getBytes());
                }else{
                    fileOutputStream.write(("   int "+option.getName()+(isKeyPrimary?"ById":"")+"(@Param(\"entity\") " +
                            "final T entity, " +
                            "@Param(\"field\") String field," +
                            (isKeyPrimary?"":"@Param(\"condition\") LinkedHashMap<String, String> condition, ")+
                            " @Param(\"tableName\") String tableName);"+StringUtil.LINK_BREAKE).getBytes());
                }
                fileOutputStream.write((StringUtil.LINK_BREAKE+StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }



































    private void createMapper(TableInfo tableInfo){
        
        File file = new File(this.mapperPath+tableInfo.getTableName()+"Mapper.xml");
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
            fileOutputStream.write(("<?xml version=\"1.0\" encoding=\"UTF-8\"?> "+StringUtil.LINK_BREAKE+"<!DOCTYPE mapper ").getBytes());
            fileOutputStream.write(("PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis" +
                    ".org/dtd/mybatis-3-mapper.dtd\">"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("<mapper namespace=\""+this.packageMapper+"."+"I"+ StringUtil.upperFirstLatter(tableInfo.getTableName())+"Mapper"+"\">"+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write(("       <resultMap id=\"resultMap\" type=\""+tableInfo.getPackageName()+
                    "."+tableInfo.getTableName()+"\">"+StringUtil.LINK_BREAKE).getBytes());
            for (TableModel model: tableInfo.getFieldInfoList()) {
                boolean is = model.getFieldNameDB().equals(tableInfo.getPrimaryKey());
                fileOutputStream.write(( "          <"+(is?
                        "id":
                        "result")+" column=\""+model.getFieldNameDB()+"\" jdbcType=\""+model.getDataTypesql().toUpperCase()+
                        "\" property=\""+model.getFieldNameJava()+"\" />"+StringUtil.LINK_BREAKE).getBytes());
            }
            fileOutputStream.write(("       </resultMap>"+StringUtil.LINK_BREAKE).getBytes());
            String sql = "      <sql id=\"columnList\">";
            for (int i = 0; i < tableInfo.getFieldInfoList().size() ; i++) {
                TableModel tableModel = tableInfo.getFieldInfoList().get(i);
                sql+=tableModel.getFieldNameDB() ;
                if (i != tableInfo.getFieldInfoList().size()-1){
                    sql+=",";
                }
            }
            sql+="</sql>";
            fileOutputStream.write((sql+StringUtil.LINK_BREAKE).getBytes());
            fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            for (MapperModel mapperModel:this.parseSqlConf.getTableModel().getMapperModelList()) {
                if (mapperModel.getOptionString().equals("insert")){
                    insert(mapperModel,fileOutputStream , tableInfo);
                }else if(mapperModel.getOptionString().equals("select")){
                    select(mapperModel,fileOutputStream,tableInfo);
                }else if(mapperModel.getOptionString().equals("update")){
                    update(mapperModel,fileOutputStream,tableInfo,false);
                    update(mapperModel,fileOutputStream,tableInfo,true);
                }
            }
            Integer integer = this.parseSqlConf.getHashMap().get(tableInfo.getTableNameDB());
            if (integer != null){
                MapperModel mapperModels = this.parseSqlConf.getMapperModelList().get(integer);
                for (MapperModel mapperModel:mapperModels.getMapperModelList()) {
                    if (mapperModel.getOptionString().equals("insert")){
                        insert(mapperModel,fileOutputStream , tableInfo);
                    }else if(mapperModel.getOptionString().equals("select")){
                        select(mapperModel,fileOutputStream,tableInfo);
                    }else if(mapperModel.getOptionString().equals("update")){
                        update(mapperModel,fileOutputStream,tableInfo,false);
                    }
                }
            }
            fileOutputStream.write(("</mapper>"+StringUtil.LINK_BREAKE).getBytes());
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
    
    /** 插入数据 */
    private void insert(MapperModel mapperModel,FileOutputStream fileOutputStream , TableInfo tableInfo){
        for (MapperOpionModel option:mapperModel.getMapperOpionModels()) {

            String insert =
                    "       <insert id=\""+option.getName()+"\""+(option.getRun()?" parameterType=\"java.util" +
                            ".List\"":" ")+
                            " useGeneratedKeys=\"true\" " +
                            " keyProperty=\""+(option.getRun()?"":"entity.")+StringUtil.parseCharacter(tableInfo.getPrimaryKey(),
                    false)+"\">"+StringUtil.LINK_BREAKE;
            insert = insert + "         insert into ${tableName} ("+StringUtil.LINK_BREAKE+"";
            insert = insert + "             ";
            if (option.getProperty().indexOf("*") != -1){
                for (int i = 0; i < tableInfo.getFieldInfoList().size(); i++) {
                    TableModel tableModel = tableInfo.getFieldInfoList().get(i);
                    if (option.getIgnor().indexOf(tableModel.getFieldNameDB()) != -1){continue;}
                    insert = insert+tableModel.getFieldNameDB()+",";
                }
                insert = insert.substring(0,insert.length()-1);
            }else{
                insert+=option.getProperty() ;   
            }
            insert+=StringUtil.LINK_BREAKE+"         ) values "+StringUtil.LINK_BREAKE ;
            if (option.getRun()){
                insert+="           <foreach collection=\"list\" item=\"entity\" index=\"index\" separator=\",\">"+StringUtil.LINK_BREAKE;
            }
            insert+="           ("+StringUtil.LINK_BREAKE;
            insert = insert + "             ";
            if (option.getProperty().indexOf("*")!= -1){
                for (int i = 0; i < tableInfo.getFieldInfoList().size(); i++) {
                    TableModel tableModel = tableInfo.getFieldInfoList().get(i);
                    if (option.getIgnor().indexOf(tableModel.getFieldNameDB()) != -1){continue;}
                    insert = insert + "#{entity."+tableModel.getFieldNameJava()+"},";
                }
                insert = insert.substring(0,insert.length()-1);
            }else{
                String[] split = option.getProperty().split(",");
                for (int i = 0; i < split.length; i++) {
                    String str = split[i];
                    TableModel tableModel = tableInfo.getTableModel(str);
                    if (tableModel != null){
                        insert = insert + "#{entity."+tableModel.getFieldNameJava()+"},";
                    }
                }
                insert = insert.substring(0,insert.length()-1);   
            }
            insert+=StringUtil.LINK_BREAKE+"         )"+StringUtil.LINK_BREAKE;
            if (option.getRun()){
                insert+="           </foreach>";
            }
            insert = insert + StringUtil.LINK_BREAKE + "     </insert>";
            try {
                fileOutputStream.write((insert+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }
    /** 获取数据 */
    public void select(MapperModel mapperModel,FileOutputStream fileOutputStream , TableInfo tableInfo){
        for (MapperOpionModel option:mapperModel.getMapperOpionModels()) {

            String select = "       <select id=\""+option.getName()+"\" "+(option.getType().trim().isEmpty()?"":
                    "parameterType=\""+option.getType()+"\" ")+(option.getResult().trim().isEmpty()?"resultMap" +
                    "=\"resultMap\">":"resultType=\""+option.getResult()+"\">")+StringUtil.LINK_BREAKE ;
            select+="           select "+StringUtil.LINK_BREAKE;
            if (option.getProperty().indexOf("*") != -1){
                select+="       <if test=\"field == null\">"+StringUtil.LINK_BREAKE;
                select+="           <include refid=\"columnList\" />"+StringUtil.LINK_BREAKE ;
                select+="       </if>"+StringUtil.LINK_BREAKE;
                select+="       <if test=\"field != null\" >"+StringUtil.LINK_BREAKE ;
                select+="           ${field}"+StringUtil.LINK_BREAKE+"         </if>"+StringUtil.LINK_BREAKE;
            }else{
                select+="       <if test=\"field == null\">"+StringUtil.LINK_BREAKE;
                select+= option.getProperty()+" "+StringUtil.LINK_BREAKE ;
                select+="       </if>"+StringUtil.LINK_BREAKE;
                select+="       <if test=\"field != null\" >"+StringUtil.LINK_BREAKE ;
                select+="           ${field}"+StringUtil.LINK_BREAKE+"         </if>"+StringUtil.LINK_BREAKE;
            }
            select+="       from ${tableName}"+StringUtil.LINK_BREAKE;
            select+="       <where>"+StringUtil.LINK_BREAKE;
            select+="           <foreach collection=\"condition\" index=\"key\" item=\"value\">"+StringUtil.LINK_BREAKE;
            select+="               ${key} ${value}"+StringUtil.LINK_BREAKE;
            select+="           </foreach>"+StringUtil.LINK_BREAKE;
            select+="       </where>"+StringUtil.LINK_BREAKE;
            select+="       <if test=\"order != null\">"+StringUtil.LINK_BREAKE;
            select+="           order by ${order}"+StringUtil.LINK_BREAKE;
            select+="       </if>"+StringUtil.LINK_BREAKE;
            select+="       <if test=\"limit != 0\">"+StringUtil.LINK_BREAKE;
            select+="           <if test=\"offset != 0\" >"+StringUtil.LINK_BREAKE;
            select+="               limit ${offset},${limit}"+StringUtil.LINK_BREAKE;
            select+="           </if>"+StringUtil.LINK_BREAKE;
            select+="           <if test=\"offset == 0\">"+StringUtil.LINK_BREAKE;
            select+="               limit ${limit}"+StringUtil.LINK_BREAKE;
            select+="           </if>"+StringUtil.LINK_BREAKE;
            select+="       </if>"+StringUtil.LINK_BREAKE;
            select+=StringUtil.LINK_BREAKE + "     </select>";
            try {
                fileOutputStream.write((select+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      

    }
//	<update id="updateByBatch" >
//    UPDATE ${tableName} SET
//    ${field}
//			<where>
//				<foreach collection="condition" index="key" item="value">
//    ${value} ${key}
//				</foreach>
//			</where>
//	</update>
    public void update(MapperModel mapperModel,FileOutputStream fileOutputStream , TableInfo tableInfo,
                       boolean isKeyPrimary){
        
        for (MapperOpionModel option:mapperModel.getMapperOpionModels()) {

            String update = "       <update id=\""+option.getName()+(isKeyPrimary?"ById":"")+"\" "+(option.getRun()?" " +
                    "parameterType" +
                    "=\"java" +
                    ".util" +
                    ".List\"":" ")+">"+StringUtil.LINK_BREAKE ;
            if (option.getRun()){
                update+="           <foreach collection=\"list\" item=\"entity\" index=\"index\" separator=\",\" >"+StringUtil.LINK_BREAKE;
            }
            update+="               update ${tableName} set "+StringUtil.LINK_BREAKE ;
            update+="               ";
            if (option.getProperty().indexOf("*") != -1){
                update+="<if test=\"field == null\">"+StringUtil.LINK_BREAKE;
                update+="                   ";
                for (int i = 0; i < tableInfo.getFieldInfoList().size(); i++) {
                    TableModel tableModel = tableInfo.getFieldInfoList().get(i);
                    if (option.getIgnor().indexOf(tableModel.getFieldNameDB()) != -1){continue;}
                    update+=tableModel.getFieldNameDB()+"=#{entity."+tableModel.getFieldNameJava()+"},";
                }
                update = update.substring(0,update.length()-1);
                update+=StringUtil.LINK_BREAKE+"           </if>"+StringUtil.LINK_BREAKE;
                update+="              <if test=\"field != null\" >"+StringUtil.LINK_BREAKE ;
                update+="                ${field}"+StringUtil.LINK_BREAKE+"             </if>";
            }else{
                String[] split = option.getProperty().split(",");
                for (int i = 0; i < split.length; i++) {
                    String str = split[i];
                    TableModel tableModel = tableInfo.getTableModel(str);
                    if (tableModel != null){
                        update = update + tableModel.getFieldNameDB() +"=#{entity."+tableModel.getFieldNameJava()+"},";
                    }
                }
                update = update.substring(0,update.length()-1);
            }
            
            if (isKeyPrimary == false){
                update+=StringUtil.LINK_BREAKE+"               <where>"+StringUtil.LINK_BREAKE ;
                update+="                <foreach collection=\"condition\" index=\"key\" item=\"value\">"+StringUtil.LINK_BREAKE;
                update+="                     ${key} ${value}"+StringUtil.LINK_BREAKE;
                update+="                </foreach>"+StringUtil.LINK_BREAKE;
                update+="            </where>"+StringUtil.LINK_BREAKE ;
            }else{
                update+=StringUtil.LINK_BREAKE+"            where"+StringUtil.LINK_BREAKE;
                update+="                    "+tableInfo.getPrimaryKey()+" = #{entity."+StringUtil.parseCharacter(tableInfo.getPrimaryKey(),false)+"}"+StringUtil.LINK_BREAKE ;
            }
            if (option.getRun()){
                update+="           </foreach>"+StringUtil.LINK_BREAKE;
            }
            update+="     </update>";
            try {
                fileOutputStream.write((update+StringUtil.LINK_BREAKE).getBytes());
                fileOutputStream.write((StringUtil.LINK_BREAKE).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
