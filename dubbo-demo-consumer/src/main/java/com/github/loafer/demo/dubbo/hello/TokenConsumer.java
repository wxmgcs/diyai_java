package com.github.loafer.demo.dubbo.hello;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
@Configurable
@ImportResource({"consumer-token.xml"})
public class TokenConsumer extends AbstractHelloConsumer {
    public static void main(String[] args){
        SpringApplication.run(TokenConsumer.class);
    }
}
