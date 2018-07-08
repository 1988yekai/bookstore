package com.yek.chinahrtComCrawler;

import com.yek.util.CustomHttpGet;
import com.yek.util.CustomHttpPost;
import com.yek.util.MyHttpClientUtil;
import com.yek.util.UrlUtil;
import com.yek.util.StringUtil;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yek on 2018-07-07.
 */
public class Crawler {
    Logger logger = LoggerFactory.getLogger(Crawler.class);

    public void login(MyHttpClientUtil httpClient, String loginUrl, String username, String password) throws Exception {
        password = MD5(password).toUpperCase();
        logger.debug("{} : {}", username, password);
        List<BasicNameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("userName", username));
        list.add(new BasicNameValuePair("password", password));
        list.add(new BasicNameValuePair("platformId", "18"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");

        CustomHttpPost httpPost = new CustomHttpPost(loginUrl, true);
        httpPost.addHeader("Accept", "*/*");
        httpPost.addHeader("Accept-Encoding", "gzip, deflate");
        httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpPost.addHeader("Host", UrlUtil.getHost(loginUrl));
        httpPost.addHeader("Referer", "http://web.chinahrt.com/cdzjnewlogin-dl.html");
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0");
        httpPost.addHeader("Origin", " http://web.chinahrt.com");
        //参数
        httpPost.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse response = httpClient.getHttpCilent().execute(httpPost);
        logger.debug("headers:" + Arrays.toString(response.getAllHeaders()));
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    public String getTranplaId(String tranplanIdUrl, MyHttpClientUtil httpClientUtil) {
        String tmp = "def1f7366eb049c49178e974f4fcff61";

        CustomHttpGet httpGet = new CustomHttpGet(tranplanIdUrl, false);
        httpGet.addHeader("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Host", UrlUtil.getHost(tranplanIdUrl));
        httpGet.addHeader("Referer", "http://web.chinahrt.com/cdzjnewlogin-dl.html");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
        try {
            CloseableHttpResponse response = httpClientUtil.getHttpCilent().execute(httpGet);
            String location = response.getFirstHeader("Location").getValue();
            tmp = location.split("trainplanId=", 2)[1];
            logger.debug(tmp);
        } catch (IOException e) {
            logger.error("", e);
        }
        return tmp;
    }

    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    public void postVisitUrl(String url, MyHttpClientUtil httpClientUtil) {
        String iframeUrl = getContent(url, httpClientUtil, url);
        iframeUrl = StringUtil.regex(iframeUrl, " src=\"(.*?)\" id=\"iframe\"");
        String iframeContent = getContent(iframeUrl, httpClientUtil, iframeUrl);
        //get param
        /*
        studyCode: f09860e2d1034d71bf7a045dc8744057
        recordUrl: http://yun.chinahrt.com/yunapi/course/update_learn_record
        updateRedisMap: 1
        recordId: 5587544662e245e0abcc2fce9f72659d
        sectionId: 7d267631-93a3-4e98-aedc-ae437463c188
        signId: 18#def1f7366eb049c49178e974f4fcff61#p2s7_6da5e088-1c83-4ec1-a4e3-be6dc8b380bf
        time: 234.645
        businessId: gp5
         */
        Map<String, String> paramMap = new HashMap<>();
        String studyCode = StringUtil.regex(iframeContent, "attrset.studyCode=\"(.*?)\"");
        String recordUrl = StringUtil.regex(iframeContent, "attrset.recordUrl=\"(.*?)\"");
        String updateRedisMap = StringUtil.regex(iframeContent, "attrset.updateRedisMap=\"(.*?)\"");
        String recordId = StringUtil.regex(iframeContent, "attrset.recordId=\"(.*?)\"");
        String sectionId = StringUtil.regex(iframeContent, "attrset.sectionId=\"(.*?)\"");
        String signId = StringUtil.regex(iframeContent, "attrset.signId=\"(.*?)\"");
        String businessId = StringUtil.regex(iframeContent, "attrset.businessId=\"(.*?)\"");
        String time = 0 + "." + Double.valueOf(Math.random() * 1000).intValue();
        String result = "{\"status\":\"0\"}";
        paramMap.put("studyCode",studyCode);
        paramMap.put("recordUrl",recordUrl);
        paramMap.put("updateRedisMap",updateRedisMap);
        paramMap.put("recordId",recordId);
        paramMap.put("sectionId",sectionId);
        paramMap.put("signId",signId);
        paramMap.put("businessId",businessId);
        paramMap.put("time",time);
        logger.debug(paramMap.toString());
        while ("{\"status\":\"0\"}".equals(result)){
            time = (int)(Double.parseDouble(paramMap.get("time")) + 30) + "." + Double.valueOf(Math.random() * 1000).intValue();
            paramMap.put("time",time);
            try {
                result = getPostContent("http://videoadmin.chinahrt.com.cn/videoPlay/takeRecord", httpClientUtil, iframeUrl, paramMap);
                logger.debug(result);
                Thread.sleep(1100);
            } catch (Exception e) {
                logger.error("", e);
                continue;
            }
        }

    }

    private String getContent(String url, MyHttpClientUtil httpClientUtil, String referer) {
        String content = null;
        CustomHttpGet httpGet = new CustomHttpGet(url, false);
        httpGet.addHeader("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Host", UrlUtil.getHost(url));
        httpGet.addHeader("Referer", "http://web.chinahrt.com/cdzjnewlogin-dl.html");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
        try {
            CloseableHttpResponse response = httpClientUtil.getHttpCilent().execute(httpGet);
            content = EntityUtils.toString(response.getEntity());
            logger.debug(content);
        } catch (IOException e) {
            logger.error("", e);
        }
        return content;
    }

    private String getPostContent(String url, MyHttpClientUtil httpClientUtil, String referer, Map<String, String> map) throws IOException {
        List<BasicNameValuePair> list = new LinkedList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");

        CustomHttpPost httpPost = new CustomHttpPost(url, false);
        httpPost.addHeader("Accept", "*/*");
        httpPost.addHeader("Accept-Encoding", "gzip, deflate");
        httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpPost.addHeader("Host", UrlUtil.getHost(url));
        httpPost.addHeader("Referer", referer);
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0");
        httpPost.addHeader("Origin", " http://" + UrlUtil.getHost(url));
        //参数
        httpPost.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse response = httpClientUtil.getHttpCilent().execute(httpPost);
        return EntityUtils.toString(response.getEntity());
    }

}
