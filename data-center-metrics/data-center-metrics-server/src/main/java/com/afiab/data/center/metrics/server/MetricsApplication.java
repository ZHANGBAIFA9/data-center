package com.afiab.data.center.metrics.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 18:50
 * @Description:
 */
@SpringBootApplication(scanBasePackages={"com.afiab.data.center.metrics"})
public class MetricsApplication {
    private static final Logger log = LoggerFactory.getLogger(MetricsApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MetricsApplication.class, args);
        log.info("MetricsApplication started successfully");
    }
}
