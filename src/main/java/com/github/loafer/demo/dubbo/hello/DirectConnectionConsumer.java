package com.github.loafer.demo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 * 演示直连提供者(演示时请启动provider集群)
 */
@Configuration
@ImportResource({"direct-connect-20882-consumer.xml"})
public class DirectConnectionConsumer extends AbstractHelloConsumer {
    public static void main(String[] args){
        SpringApplication.run(DirectConnectionConsumer.class);
    }
}
