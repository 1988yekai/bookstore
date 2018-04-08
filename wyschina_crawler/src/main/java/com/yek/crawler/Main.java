package com.yek.crawler;

import com.yek.crawler.util.CustomHttpGet;
import com.yek.crawler.util.CustomHttpPost;
import com.yek.crawler.util.MyHttpClientUtil;
import com.yek.crawler.util.UrlUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018-4-8.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        MyHttpClientUtil httpClientUtil = new MyHttpClientUtil();


        String loginUrl = "http://sso.wyschina.com/SSOAuth";//登录url
        String loginUrl1 = "http://w.wyschina.com/custom/login.action?action=http%3A%2F%2Fw.wyschina.com%2Fhome%2Fhome.action";//访问获取jsession
        String homeUrl = "http://w.wyschina.com/home/home.action";//登录成功后跳转url
        String uriEn = URLEncoder.encode("255|0|0","UTF-8");
        String captchaUrl = "http://sso.wyschina.com/createimage?Rgb="+uriEn+"&r="+ (int)(Math.random()*1000);//验证码url
        System.out.println("验证码url： " + captchaUrl);

        String myHomeUrl = "http://w.wyschina.com/order/firstPage.action";

        List<BasicNameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("username", "bellye"));
        list.add(new BasicNameValuePair("password", "wys745839"));
        list.add(new BasicNameValuePair("random", httpClientUtil.getCaptcha(captchaUrl)));
        list.add(new BasicNameValuePair("url", "http://w.wyschina.com/custom/login.action?action=http%3A%2F%2Fw.wyschina.com%2Fhome%2Fhome.action"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
        CustomHttpPost httpPost = new CustomHttpPost( loginUrl, true );
        httpPost.addHeader("Accept", "*/*");
        httpPost.addHeader("Accept-Encoding", "gzip, deflate");
        httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpPost.addHeader("Host", UrlUtil.getHost(loginUrl));
        httpPost.addHeader("Referer", UrlUtil.getRootUrl(loginUrl));
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0");
        //参数
        httpPost.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse response = httpClientUtil.getHttpCilent().execute(httpPost);
        byte[] bytes = EntityUtils.toByteArray(response.getEntity());
        String content = "";
        String unicode = "UTF-8";
        if(StringUtils.isEmpty(unicode)){
            content = new String(bytes);
        }else{
            content = new String(bytes,unicode);
        }
        if (StringUtils.isNotBlank(content)){
            System.out.println(content);
        }

        // 访问homeUrl
        CustomHttpGet httpGet = new CustomHttpGet( loginUrl1, false );
        httpGet.addHeader("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Host", UrlUtil.getHost(loginUrl1));
        httpGet.addHeader("Referer", "http://sso.wyschina.com/login.jsp?url=http%3A%2F%2Fw.wyschina.com%2Fcustom%2Flogin.action%3Faction%3Dhttp%253A%252F%252Fw.wyschina.com%252Fhome%252Fhome.action");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
        response = httpClientUtil.getHttpCilent().execute(httpGet);
//        httpClientUtil.setCookieStore(response);

        String getResult = EntityUtils.toString(response.getEntity());// 获得返回的结果
        System.out.println(getResult);

        // 访问homeUrl
        httpGet = new CustomHttpGet( homeUrl, false );
        httpGet.addHeader("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Host", UrlUtil.getHost(homeUrl));
        httpGet.addHeader("Referer", "http://sso.wyschina.com/login.jsp?url=http%3A%2F%2Fw.wyschina.com%2Fcustom%2Flogin.action%3Faction%3Dhttp%253A%252F%252Fw.wyschina.com%252Fhome%252Fhome.action");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
        response = httpClientUtil.getHttpCilent().execute(httpGet);
        getResult = EntityUtils.toString(response.getEntity());// 获得返回的结果
        System.out.println(getResult);
        System.out.println("=====================================");
        // 访问 myHomeUrl
        httpGet = new CustomHttpGet( myHomeUrl, false );
        httpGet.addHeader("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Host", UrlUtil.getHost(myHomeUrl));
        httpGet.addHeader("Referer", "http://sso.wyschina.com/login.jsp?url=http%3A%2F%2Fw.wyschina.com%2Fcustom%2Flogin.action%3Faction%3Dhttp%253A%252F%252Fw.wyschina.com%252Fhome%252Fhome.action");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
        response = httpClientUtil.getHttpCilent().execute(httpGet);
        getResult = EntityUtils.toString(response.getEntity());// 获得返回的结果
        System.out.println(getResult);
    }


}