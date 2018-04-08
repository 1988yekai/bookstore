package com.yek.crawler.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-4-8.
 */
public class MyHttpClientUtil {
    protected static Logger logger = LoggerFactory.getLogger(MyHttpClientUtil.class);
    public CookieStore cookieStore = new BasicCookieStore();
    public HttpClientContext context = null;
    public CloseableHttpClient httpCilent = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

    public CloseableHttpClient getHttpCilent() {
        return httpCilent;
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }

    public String getCaptcha(String captchaUrl) {
        String refererUrl = "http://sso.wyschina.com/login.jsp?url=http%3A%2F%2Fw.wyschina.com%2Fcustom%2Flogin.action%3Faction%3Dhttp%253A%252F%252Fw.wyschina.com%252Fhome%252Fhome.action";

        CustomHttpGet httpGet = new CustomHttpGet(captchaUrl, false);
        httpGet.addHeader("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Host", UrlUtil.getHost(captchaUrl));
        httpGet.addHeader("Referer", refererUrl);
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
//        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            CloseableHttpResponse response = getHttpCilent().execute(httpGet);
            byte[] bytes = EntityUtils.toByteArray(response.getEntity());
//            String content = new String(bytes);
            boolean flag = writeFile("captcha.png", bytes);
//            flag = writeFile( imagePath+imageName, content.getBytes( Charset.forName("ISO-8859-1") ) );
            System.out.println("captchaStore  =======执行完毕：" + flag);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("", e);
            return null;
        }
        System.out.println("请输入验证码：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return input;
    }

    /**
     * 写文件
     *
     * @param fileName
     * @param content
     * @return
     */
    public boolean writeFile(String fileName, byte[] content) {
        boolean flag = true;
        FileOutputStream out = null;
        try {
            File file = new File("imgs");
            //如果文件夹不存在则创建
            if (!file.exists() && !file.isDirectory()) {
                System.out.println("创建目录");
                file.mkdir();
            }
            out = new FileOutputStream(file.getAbsolutePath() + "/" + fileName); // 输出文件路径
            out.write(content);
            out.flush();
            out.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
            try {
                if (out != null) {
                    out.close();
                    out = null;
                }
            } catch (IOException e1) {
                e1.printStackTrace();

            }
            flag = false;
        }
        return flag;
    }
    public void setCookieStore(HttpResponse httpResponse) {
        System.out.println("----setCookieStore");
        // JSESSIONID
        String setCookie = httpResponse.getFirstHeader("Set-Cookie")
                .getValue();
        String JSESSIONID = setCookie.substring("JSESSIONID=".length(),
                setCookie.indexOf(";"));
        System.out.println("JSESSIONID:" + JSESSIONID);
        // 新建一个Cookie
        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID",
                JSESSIONID);
        cookie.setVersion(0);
        cookie.setDomain("w.wyschina.com");
        cookie.setPath("/");
        // cookie.setAttribute(ClientCookie.VERSION_ATTR, "0");
        // cookie.setAttribute(ClientCookie.DOMAIN_ATTR, "127.0.0.1");
        // cookie.setAttribute(ClientCookie.PORT_ATTR, "8080");
        // cookie.setAttribute(ClientCookie.PATH_ATTR, "/CwlProWeb");
        this.cookieStore.addCookie(cookie);
    }
}
