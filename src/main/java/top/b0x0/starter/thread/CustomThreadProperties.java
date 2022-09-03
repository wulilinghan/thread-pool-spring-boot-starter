package top.b0x0.starter.thread;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author wuliling Created By 2022-09-03 14:42
 **/
@Configuration
@ConfigurationProperties(prefix = "custom.tread")
public class CustomThreadProperties {

    private String nameTread = "custom-t-";
    private boolean isDaemon = false;

    private int corePoolSize = Runtime.getRuntime().availableProcessors();
    private int maximumPoolSize = Runtime.getRuntime().availableProcessors();
    private long keepAliveTime = 60;
    private TimeUnit timeUnit = TimeUnit.SECONDS;
    private int queueCapacity = Runtime.getRuntime().availableProcessors();

    public CustomThreadProperties() {
    }

    public CustomThreadProperties(
            int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit, int queueCapacity) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.queueCapacity = queueCapacity;
    }

    public String getNameTread() {
        return nameTread;
    }

    public void setNameTread(String nameTread) {
        this.nameTread = nameTread;
    }

    public boolean isDaemon() {
        return isDaemon;
    }

    public void setDaemon(boolean daemon) {
        isDaemon = daemon;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }


}
