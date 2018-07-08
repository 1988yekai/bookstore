package com.yek.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil{

    /**
     * 正则表达式匹配
     * @param riginal 原文
     * @param reg 正则表达式
     * @return
     */
    public static String regex(String riginal, String reg){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(riginal);
        if(matcher.find()){
            String ret = matcher.group(1);
            return ret;
        }else{
            return "";
        }
    }
}