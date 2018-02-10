package com.github.loafer.demo.dubbo.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

/**
 * @author zhaojh.
 */
public abstract class AbstractProvider implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... strings) throws Exception {
        logger.info("服务已启动。");

        if(strings.length==1){
            logger.info("监听端口：{}", strings[0]);
        }

        logger.info("输入 [quit] or [q]　退出程序.");
        Scanner scanner = new Scanner(System.in);
        String read = scanner.nextLine();

        while (true){
            if(read.equalsIgnoreCase("quit") || read.equalsIgnoreCase("q")){
                System.exit(0);
            }

            read = scanner.nextLine();
        }
    }
}
