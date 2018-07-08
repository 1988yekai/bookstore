package com.yek.util;

/**
 * Created with IntelliJ IDEA.
 * User: yek
 * Date: 15-6-1
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
public class UrlUtil {
    /**
     * 获得域名
     * @param url
     * @return
     */
    public static String getRootUrl( String url ) {
        String rootUrl = url;
        if( url.contains( "http://" ) ) {
            int idx = url.indexOf( "/", "http://".length() );
            if(idx != -1){
                rootUrl = url.substring( 0, idx );
            }
        } else if( url.contains( "https://" ) ) {
            int idx = url.indexOf( "/", "https://".length() );
            if(idx != -1){
                rootUrl = url.substring( 0, idx );
            }
        }

        return rootUrl;
    }

    /**
     * 获得主机名
     * @param url
     * @return
     */
    public static String getHost(String url){
        String rootUrl = url;
        if( url.contains( "http://" ) ) {
            int idx = url.indexOf( "/", "http://".length() );
            if(idx != -1){
                rootUrl = url.substring( 0, idx );
            }
            rootUrl = rootUrl.substring("http://".length());
        } else if( url.contains( "https://" ) ) {
            int idx = url.indexOf( "/", "https://".length() );
            if(idx != -1){
                rootUrl = url.substring( 0, idx );
            }
            rootUrl = rootUrl.substring("https://".length());
        }
        return rootUrl;
    }

    public static void main( String[] args ) {
        String url = "http://tieba.baidu.com/f?ie=utf-8&kw=it";
        System.out.println(getRootUrl(url));
        System.out.println(getHost(url));
    }
}
