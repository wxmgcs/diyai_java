package com.github.loafer.demo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
@SpringBootApplication(exclude = ZookeeperProvider.class)
@ImportResource({"applicationContext.xml", "provider-multicast.xml"})
public class MulticastProvider extends AbstractProvider{
    public static void main(String[] args){
        SpringApplication.run(MulticastProvider.class);
    }
}
