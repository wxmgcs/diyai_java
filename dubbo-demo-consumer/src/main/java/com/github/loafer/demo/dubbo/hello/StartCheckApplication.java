package com.github.loafer.demo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * @author zhaojh.
 */
@Configuration
@ImportResource({"consumer-start-check.xml"})
public class StartCheckApplication extends AbstractHelloConsumer {
    public static void main(String[] args){
        SpringApplication.run(StartCheckApplication.class);
    }
}
