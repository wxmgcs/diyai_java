package com.github.loafer.demo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
//@SpringBootApplication(exclude = MulticastProvider.class)
@Configuration
@ImportResource({"applicationContext.xml","provider-zookeeper.xml"})
public class ZookeeperProvider extends AbstractProvider {

    public static void main(String[] args){
        SpringApplication.run(ZookeeperProvider.class, args);
    }
}
