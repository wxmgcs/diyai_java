package com.github.loafer.demo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
@Configuration
@ImportResource({"consumer-zookeeper.xml"})
public class ZookeeperConsumer extends AbstractHelloConsumer {
    public static void main(String[] args){
        SpringApplication.run(ZookeeperConsumer.class);
    }
}
