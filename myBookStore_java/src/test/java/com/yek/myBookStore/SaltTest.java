package com.yek.myBookStore;

import com.yek.myBookStore.common.MD5;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Administrator on 2018-2-28.
 */
public class SaltTest {
    public static void main(String[] args) {
        String password = "yek";
        String salt = MD5.encode("0.123","utf-8");
        System.out.println(salt);
        //user_info.salt = 677738b969d6037efce2c328c6814580
        SimpleHash sh = new SimpleHash("md5", password, ByteSource.Util.bytes("yek" + salt), 2);
        System.out.println(sh.toString());
        //user_info.password = sh.toString() = d607e0d3e984fe6f272659026fa70e7f
    }
}
