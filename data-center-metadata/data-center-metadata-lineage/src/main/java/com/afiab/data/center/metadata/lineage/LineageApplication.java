package com.afiab.data.center.metadata.lineage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/23 16:15
 * @Description:
 */
@SpringBootApplication(scanBasePackages={"com.afiab.data.center.metadata"})
public class LineageApplication {
    private static final Logger log = LoggerFactory.getLogger(LineageApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(LineageApplication.class, args);
        log.info("LineageApplication started successfully");
    }
}
