package com.yek.taskExecutor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by Administrator on 2018-06-02.
 */
@Configuration
@ComponentScan("com.yek.taskExecutor")
@EnableAsync //此注解开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {
    @Nullable
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(25);
        threadPoolTaskExecutor.setKeepAliveSeconds(3);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
