package com.qf;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan(value = "com.qf.mapper")
public class RunApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(RunApp.class,args);
    }
}
