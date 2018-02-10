package com.github.loafer.demo.dubbo.hello;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhaojh.
 */
@Configurable
@ImportResource({"applicationContext.xml","provider-token.xml"})
public class TokenProvider extends AbstractProvider {
    public static void main(String[] args){
        SpringApplication.run(TokenProvider.class);
    }
}
