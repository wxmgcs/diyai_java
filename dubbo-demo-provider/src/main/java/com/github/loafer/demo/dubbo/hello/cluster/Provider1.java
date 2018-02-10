package com.github.loafer.demo.dubbo.hello.cluster;

import com.github.loafer.demo.dubbo.hello.AbstractProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
@Configuration
@ImportResource({"applicationContext.xml", "cluster/hello-provider-20880.xml"})
public class Provider1 extends AbstractProvider {
    public static void main(String[] args){
        SpringApplication.run(Provider1.class, "20880");
    }
}
