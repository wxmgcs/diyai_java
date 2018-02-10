package com.github.loafer.demo.dubbo.hello.controller;

import com.github.loafer.demo.dubbo.api.hello.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojh.
 */
@RestController
public class HelloController implements HelloService {

    @Override
    @RequestMapping(value = "hello")
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
