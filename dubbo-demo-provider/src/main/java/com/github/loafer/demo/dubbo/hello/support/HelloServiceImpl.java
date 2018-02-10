package com.github.loafer.demo.dubbo.hello.support;

import com.alibaba.dubbo.rpc.RpcContext;
import com.github.loafer.demo.dubbo.api.hello.HelloService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhaojh.
 */
public class HelloServiceImpl implements HelloService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String sayHello(String name) {
        logger.info("receive from {} remote call.", RpcContext.getContext().getRemoteAddressString());
        return StringUtils.isNotBlank(name) ? "Hello, " + name + '!':"Hello, World!";
    }
}
