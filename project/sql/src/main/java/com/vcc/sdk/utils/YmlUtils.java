package com.vcc.sdk.utils;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class YmlUtils {
    
    private String path ;
    private Map<String,HashMap<String,Object>> map = new HashMap<>() ;
    private String first ;
    private String second ;
    private String third ;
    private String fouth ;
    
    public static void main(String[] args) {
        YmlUtils ymlUtils = new YmlUtils("src/main/resource/mapper.yml");
        ymlUtils.parseYML();
    }
    
    public YmlUtils(String path){
        this.path = path ;
        parseYML();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public <T extends Object> T  getValueWithKey(String key, Class<T> tClass){
        if (key == null) {return null; }
        String[] split = key.split("\\.");
        Object stringMap = this.map ;
        for (int i = 0; i < split.length; i++) {
            String value = split[i];
            if (stringMap == null){
                return null ;
            }
            if (stringMap instanceof HashMap){
                stringMap = ((HashMap) stringMap).get(value);
            }
        }
        if (stringMap instanceof String){
            stringMap = ((String) stringMap).trim();
        }
        return (T) stringMap;
    }

    public Map<String, HashMap<String, Object>> getMap() {
        return map;
    }

    public void setMap(Map<String, HashMap<String, Object>> map) {
        this.map = map;
    }

    /** yml 解析*/
    public void parseYML(){
        File file = new File(this.path);
        first = null ;
        second = null ;
        third = null ;
        fouth = null ;
        try {
            BufferedReader bufferedReader = null ;
            if (this.path.indexOf("jar!") != -1){
                String substring = this.path.substring(this.path.indexOf("jar!"), this.path.length());
                substring = substring.substring(5,substring.length());
                InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(substring);
                bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            }else{
                FileReader fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
            }
            StringBuffer stringBuffer = new StringBuffer();
            String string = "";
            while (true){
                try {
                    if (!((string = bufferedReader.readLine()) != null)) {
                        break;
                    }else{
                        parseContent(string);
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
        System.out.println(this.map.toString());
    }
    
    public void parseContent(String content){
        String s = StringUtil.parLineFrontBlank(content);
        if (s.indexOf("#") == 0 || s.trim().length()==0){
            return;
        }
        int index = content.replaceAll("([ ]*).*","$1").length();
        if (index == 6){
            fouth = null ;
        }else if(index == 4){
            third = null ;
        }else if(index == 2){
            second = null ;
        }else if(index == 0){
            first = null ;
        }
//        System.out.println(content.replaceAll("([ ]*).*", "$1").length());
        int i = s.trim().indexOf(":");
        String substring = s.trim().substring(0, i);
        if (s.trim().split(":").length>1){
            if (s.trim().indexOf("#") != -1){
                String[] split = s.trim().split("#");
                s = split[0];
            }
            String substring1 = s.trim().substring(i + 1, s.trim().length()).trim();
            if (fouth != null){
                HashMap hashMap = (HashMap) map.get(first).get(second);
                HashMap o = (HashMap) hashMap.get(third);
                HashMap hashMap1 = (HashMap) o.get(fouth);
                hashMap1.put(substring,substring1);
            }else if(third != null){
                HashMap hashMap = (HashMap) map.get(first).get(second);
                HashMap o = (HashMap) hashMap.get(third);
                o.put(substring,substring1);
            }else if(second != null){
                HashMap hashMap = (HashMap) map.get(first).get(second);
                hashMap.put(substring,substring1);
            }else if(first != null){
                map.get(first).put(substring,substring1);
            }
        }else{
            if (first == null){
                first = substring ;
                map.put(substring,new HashMap<>());
            }else if(second == null){
                second = substring ;
                map.get(first).put(second,new HashMap<>());
            }else if(third == null){
                third = substring ;
                HashMap hashMap = (HashMap) map.get(first).get(second);
                hashMap.put(third,new HashMap<>());
            }else if(fouth == null){
                fouth = substring ;
                HashMap hashMap = (HashMap) map.get(first).get(second);
                HashMap o = (HashMap) hashMap.get(third);
                o.put(fouth,new HashMap<>());
            }
        }
        
    }
    
    
}
