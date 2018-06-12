package com.yek.taskScheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yek on 2018-06-12.
 */
@Service
public class ScheduledTaskService {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:                                                                                            ss");

    @Scheduled(fixedRate = 5000)
    public void reportTime(){
        System.out.println("每5秒执行一次，执行时间： " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/3 * * * * ? ")
    public void fixTimeExecution(){
        System.out.println("在指定时间： " + dateFormat.format(new Date()) + " 执行！");
    }
}
