package com.yek.chinahrtComCrawler;

import com.yek.util.FileUtil;
import com.yek.util.MyHttpClientUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by yek on 2018-07-07.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MyHttpClientUtil httpClientUtil = new MyHttpClientUtil();
        Crawler crawler = new Crawler();
        //1. 登录
        String loginUrl = "http://web.chinahrt.com/loginValid?t=" + new Date().getTime();
        Properties properties = new Properties();
        properties.load(new FileInputStream("./config/username.properties"));
        crawler.login(httpClientUtil, loginUrl, properties.getProperty("username"), properties.getProperty("password"));
        //2. get trainplanId
//        String tranplanIdUrl = "http://web.chinahrt.com/trainplan";
//        String tranplaId = crawler.getTranplaId(tranplanIdUrl, httpClientUtil);
        //3. loop visit url
//        课程主页 https://web.chinahrt.com/studying/selected_course?trainplanId=77cba5cedd2a461aab5d0b14033afef5
        List<String> urlList = FileUtil.getContentList("./config/chinahrtUrlList.txt");
        int i = 0;
        for (String url : urlList) {
            System.out.println("line: " + ++i);
            if (StringUtils.isNoneBlank(url))
                crawler.postVisitUrl(url, httpClientUtil);
        }
    }
}
