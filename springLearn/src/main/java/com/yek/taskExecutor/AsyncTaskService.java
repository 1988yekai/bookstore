package com.yek.taskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018-06-02.
 */
@Service
public class AsyncTaskService {

    @Async // 标明该方法为异步方法 如果在类上，则该类所有方法为异步方法
    public void executeAsyncTask(Integer integer) {
        System.out.println("执行异步任务：" + integer);
    }

    @Async // 标明该方法为异步方法
    public void executeAsyncTaskPlus(Integer integer) {
        System.out.println("执行异步任务 + 1：" + (integer + 1));
    }
}
