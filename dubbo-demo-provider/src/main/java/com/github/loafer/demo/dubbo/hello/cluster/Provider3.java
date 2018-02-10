package com.github.loafer.demo.dubbo.hello.cluster;

import com.github.loafer.demo.dubbo.hello.AbstractProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
@Configuration
@ImportResource({"applicationContext.xml", "cluster/hello-provider-20882.xml"})
public class Provider3 extends AbstractProvider {
    public static void main(String[] args){
        SpringApplication.run(Provider3.class, "20882");
    }
}
