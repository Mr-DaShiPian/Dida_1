package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan(value = "com.qf.mapper")
public class RunApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(RunApp.class,args);
    }
}
