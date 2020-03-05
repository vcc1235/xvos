package com.vcc.sdk.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String LINK_BREAKE = "\r\n";
    /** 首字母大写 */
    public static String upperFirstLatter(String letter){
        return letter.substring(0, 1).toUpperCase()+letter.substring(1);
    }
    /** 首字母小写 */
    public static String lowerFirstLatter(String letter){
        return letter.substring(0, 1).toLowerCase()+letter.substring(1);
    }
    /** 删除字符前面的空格 */
    public static String parLineFrontBlank(String tempStr) {

        if (tempStr.startsWith(" ")) {
            String newTempStr = tempStr.substring(1);
            return parLineFrontBlank(newTempStr);
        }

        return tempStr;
    }
    /** 根据下划线控制驼峰写法 */
    public static String parseCharacter(String sql,boolean capture){
        if (sql == null){
            return sql ;
        }
        String[] s = sql.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<s.length;i++){
            String s1 = s[i];
            if (capture == false && i==0){
                stringBuilder.append(s1);
                continue;
            }
            stringBuilder.append(upperFirstLatter(s1));
        }
        return stringBuilder.toString();
    }
    
    public static List<String> parseString(String string, String regex){
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(string);
        ArrayList<String> strings = new ArrayList<>();
        if (matcher.find()){
            strings.add(matcher.group());
        }
        return strings ;
    }
    
    

}
