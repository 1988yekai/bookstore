package com.yek.chinahrtComCrawler;

import org.apache.commons.lang3.StringUtils;
import sun.management.snmp.jvmmib.JvmThreadInstanceEntryMBean;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yek on 2018-07-07.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        String password = "12191006";
        password = Crawler.MD5(password);
        System.out.println(password);

        String time = 0 + "." + Double.valueOf(Math.random() * 1000).intValue();
        System.out.println(time);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("time", time);
        Double d = Double.parseDouble(paramMap.get("time"));
        int end = Double.valueOf(Math.random() * 1000).intValue();
//        time = (Double.parseDouble(paramMap.get(time)) + 30) + "." + Double.valueOf(Math.random() * 1000).intValue();
        time = (int)(Double.parseDouble(paramMap.get("time")) + 30) + "." + Double.valueOf(Math.random() * 1000).intValue();

        System.out.println(time);

    }
}
