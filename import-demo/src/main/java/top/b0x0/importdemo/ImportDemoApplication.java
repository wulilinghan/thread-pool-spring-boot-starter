package top.b0x0.importdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class ImportDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportDemoApplication.class, args);
    }


    @RestController
    class EchoController {
        @Autowired
        @Qualifier("myStarterThreadPool")
        ThreadPoolExecutor myThreadPoolExecutor;

        @GetMapping("echo")
        public String echo() {
            System.out.println(currentThreadName() + " hello... ");
            myThreadPoolExecutor.execute(() -> {
                String currentThreadName = currentThreadName();
                System.out.println("currentThreadName = " + currentThreadName);
            });
            return currentThreadName();
        }
    }

    static String currentThreadName() {
        return Thread.currentThread().getName();
    }
}
