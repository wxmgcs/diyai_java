package com.github.loafer.demo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
@SpringBootApplication
@ImportResource({"consumer-multicast.xml"})
public class MulticastConsumer extends AbstractHelloConsumer {
    public static void main(String[] args){
        SpringApplication.run(MulticastConsumer.class);
    }
}
