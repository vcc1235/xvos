package com.vcc.sdk;

import com.vcc.sdk.sql.JavaShell;
import com.vcc.sdk.utils.YmlUtils;

import java.net.URL;

public class Main {
    public static void main(String[] args) {

//        String path = "E:\\vcc\\mall.sql";
//        JavaShell javaShell = new JavaShell(path,"com.vcc.sdk.dao");
//        /** 创建dao文件 */
//        javaShell.createJavaFile();
//        /** 创建 mapper 文件 */
//        javaShell.createMapperXML("src/main/resource/mapper.yml","src/main/resource/mapper/","com.vcc.sdk.mapper" +
//                ".mapper");
//         /** 创建md文件 */   
//        javaShell.createSqlMd("src/main/resource/sql.md");

       
        

        JavaShell javaShell = new JavaShell("src/main/resource/list.yml");
        javaShell.createMapperXML();
        javaShell.createSqlMd();
        javaShell.createJavaFile();

    }
    
    
    public static void test(){
        
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("fdsa");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("fds21321a");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();



    }
    
    
}
