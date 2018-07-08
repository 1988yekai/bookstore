package com.yek.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yek on 2018-07-07.
 */
public class FileUtil {
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);
    public static List<String> getContentList(String filepath) {
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            FileReader reader = new FileReader(filepath);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (StringUtils.isNoneBlank(line))
                    list.add(line);
            }
        } catch (Exception e) {
            logger.error("",e);
        } finally {
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.error("",e);
                }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> contentList = FileUtil.getContentList("config/chinahrtUrlList.txt");
        System.out.println(contentList);

    }
}
