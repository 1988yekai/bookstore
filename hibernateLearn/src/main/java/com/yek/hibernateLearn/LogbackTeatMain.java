package com.yek.hibernateLearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018-03-29.
 */
public class LogbackTeatMain {
    private static Logger logger = LoggerFactory.getLogger(LogbackTeatMain.class);
    public static void main(String[] args) {
        logger.debug("debug, level!");
        logger.info("info, level!");
        logger.warn("warn, level!");
        logger.error("error, level!");
    }
}
