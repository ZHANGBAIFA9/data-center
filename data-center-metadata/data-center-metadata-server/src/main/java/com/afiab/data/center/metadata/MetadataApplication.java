package com.afiab.data.center.metadata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/18 16:18
 * @Description:
 */
@SpringBootApplication(scanBasePackages={"com.afiab.data.center.metadata"})
public class MetadataApplication {
    private static final Logger log = LoggerFactory.getLogger(MetadataApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MetadataApplication.class, args);
        log.info("Bootstrap started successfully");
    }
}
