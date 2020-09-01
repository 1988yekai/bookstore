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

    public static void main(String[] args) {
        String test = " attrset.recordId = \"b6e5334d8061449fbb52749d13538dd7\";";
        String recordId = StringUtil.regex(test, "attrset.recordId\\s?=\\s?\"(.*?)\"");
        System.out.println(recordId);

    }
}