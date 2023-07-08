package com.config.threadpool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author DC Yuan
 * @version 1.0
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 核心线程数
     */
    @Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize;


    /**
     * 最大线程数
     */
    @Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize;


    /**
     * 队列最大长度
     */
    @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity;


    /**
     * 线程池维护线程所允许的空闲时间
     */
    @Value("${async.executor.thread.keep_alive_seconds}")
    private int keepAliveSeconds;


    @Bean("customTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);  //核心线程数10：线程池创建时候初始化的线程数
        executor.setMaxPoolSize(maxPoolSize);  //最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setQueueCapacity(queueCapacity); //缓冲队列200：用来缓冲执行任务的队列
        executor.setKeepAliveSeconds(keepAliveSeconds); //允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
        executor.setWaitForTasksToCompleteOnShutdown(true); // 该方法用来设置 线程池关闭 的时候 等待 所有任务都完成后，再继续 销毁 其他的 Bean，这样这些 异步任务 的 销毁 就会先于 数据库连接池对象 的销毁。
        executor.setThreadNamePrefix("AsyncExecutorThread-");//线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//线程池对拒绝任务(无线程可用)的处理策略
        executor.initialize();
        return executor;
    }
}
