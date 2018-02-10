package com.github.loafer.demo.dubbo.hello;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
@Configurable
@ImportResource({"applicationContext.xml","springrest-protocol.xml"})
public class SpringRestProvider extends AbstractProvider {
    public static void main(String[] args){
        SpringApplication.run(SpringRestProvider.class);
    }
}
