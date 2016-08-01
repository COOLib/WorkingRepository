package com.chisw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Executor {

    private static final Logger log = LoggerFactory.getLogger(Executor.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-context.xml");

        Executor executor = context.getBean(Executor.class);
        executor.start(args);
    }

    private void start(String[] args) {

        SpringApplication.run(Executor.class, args);

    }
}
