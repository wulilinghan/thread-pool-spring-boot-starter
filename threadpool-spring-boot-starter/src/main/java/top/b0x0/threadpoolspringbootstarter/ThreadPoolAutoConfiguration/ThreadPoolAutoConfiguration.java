package top.b0x0.threadpoolspringbootstarter.ThreadPoolAutoConfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.nio.ch.ThreadPool;

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
    @ConditionalOnClass(ThreadPoolExecutor.class) // 需要项目中存在ThreadPooLExecutor类。 该类为JDK 自带，所以-定成立。
    public ThreadPoolExecutor myStarterThreadPool() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(availableProcessors, availableProcessors,
                60, TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>(availableProcessors)
                , new NamedThreadFactory("my-pool-", false)
                , new ThreadPoolExecutor.CallerRunsPolicy());

    }
}
