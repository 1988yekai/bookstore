package com.yek.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

/**
 * Created by Administrator on 2018-4-8.
 */
public class CustomHttpGet extends HttpGet {
    /**
     * 自定义GET请求
     * @param url
     */
    public CustomHttpGet(String url, boolean redirect){
        super(url);
        //统一设置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10000).setConnectTimeout(10000)
                .setSocketTimeout(10000).setRedirectsEnabled(redirect).build();
        this.setConfig(requestConfig);
    }
}

