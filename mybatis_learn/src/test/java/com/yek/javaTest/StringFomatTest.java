package com.yek.javaTest;

import org.junit.Test;

/**
 * Created by yek on 2018-08-31.
 */
public class StringFomatTest {
    @Test
    public void test1(){
        System.out.printf("%-4d%4s%4s%n 1231",111, "123", "312");
        System.out.println(String.format("%5s%n%4s","good","day"));
    }
}
