package top.b0x0.starter.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author TANG
 * @since 2021-07-27
 * @since JDK1.8
 */
@Configuration
public class ThreadPoolAutoConfiguration {

    @Bean("myStarterThreadPool")
    public ThreadPoolExecutor myStarterThreadPool() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(availableProcessors, availableProcessors,
                60, TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>(availableProcessors)
                , new NamedThreadFactory("my-pool-", false)
                , new ThreadPoolExecutor.CallerRunsPolicy());

    }
}
