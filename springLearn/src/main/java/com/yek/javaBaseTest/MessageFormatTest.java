package com.yek.javaBaseTest;

import java.text.MessageFormat;

/**
 * Created by yek on 2018-06-12.
 */
public class MessageFormatTest {
    public static void main(String[] args) {
        String yek = MessageFormat.format("My name is {0}", "yek");
        System.out.println(yek);
    }
}
