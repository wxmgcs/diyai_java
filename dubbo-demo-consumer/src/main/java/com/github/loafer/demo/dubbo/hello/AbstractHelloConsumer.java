package com.github.loafer.demo.dubbo.hello;

import com.alibaba.dubbo.rpc.RpcContext;
import com.github.loafer.demo.dubbo.api.hello.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.Resource;
import java.util.Scanner;

/**
 * @author zhaojh.
 */
public abstract class AbstractHelloConsumer implements CommandLineRunner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private HelloService helloService;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("输入 [quit] or [q]　退出应用.");
        logger.info("输入 [run] or [r] 启动服务调用.");

        Scanner scanner = new Scanner(System.in);
        String read = scanner.nextLine();
        while (true){
            if(read.equalsIgnoreCase("quit")||read.equalsIgnoreCase("q")){
                System.exit(0);
            }

            if(read.equalsIgnoreCase("run") || read.equalsIgnoreCase("r")){
                logger.info(helloService.sayHello("Dubbo"));
                logger.info("invoke remote service: " + RpcContext.getContext().getRemoteAddressString());
            }

            read = scanner.nextLine();
        }
    }
}
