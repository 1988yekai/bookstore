package com.yek.mybatis;

/**
 * Created by yek on 2018-07-22.
 */
public class Main {
    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            logger.trace("trace: " + i);
            logger.debug("debug: " + i);
            logger.info("info: " + i);
            logger.warn("warn: " + i);
            logger.error("error: " + i);
        }
    }
}
