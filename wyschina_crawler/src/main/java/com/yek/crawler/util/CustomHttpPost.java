package com.yek.crawler.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;

/**
 * Created by Administrator on 2018-4-8.
 */
public class CustomHttpPost extends HttpPost {
    /**
     * 设置超时时间
     * @param url
     */
    public CustomHttpPost(String url, boolean redirect){
        super(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10000).setConnectTimeout(10000)
                .setSocketTimeout(10000).setRedirectsEnabled(redirect).build();
        this.setConfig(requestConfig);
    }
}
