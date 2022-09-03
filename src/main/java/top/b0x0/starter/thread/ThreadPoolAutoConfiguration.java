package top.b0x0.starter.thread;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author TANG
 * @since 2021-07-27
 * @since JDK1.8
 */
@Configuration
@EnableConfigurationProperties(CustomThreadProperties.class)
public class ThreadPoolAutoConfiguration {

    @Resource
    CustomThreadProperties customThreadProperties;

    @Bean("myStarterThreadPool")
    public ThreadPoolExecutor myStarterThreadPool() {
        return new ThreadPoolExecutor(
                customThreadProperties.getCorePoolSize(),
                customThreadProperties.getMaximumPoolSize(),
                customThreadProperties.getKeepAliveTime(),
                customThreadProperties.getTimeUnit()
                , new LinkedBlockingQueue<Runnable>(customThreadProperties.getQueueCapacity())
                , new NamedThreadFactory(customThreadProperties.getNameTread(), customThreadProperties.isDaemon())
                , new ThreadPoolExecutor.CallerRunsPolicy());

    }
}
