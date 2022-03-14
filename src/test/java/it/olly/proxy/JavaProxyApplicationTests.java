package it.olly.proxy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.olly.proxy.caller.GenericInvocationUtils;
import it.olly.proxy.service.MyServiceInterface;

@SpringBootTest
class JavaProxyApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GenericInvocationUtils invocationUtils;

    @Test
    void doTest() {
        logger.info("doTest()");
        MyServiceInterface service = invocationUtils.getProxy(MyServiceInterface.class);
        Integer ret = service.doSomething("ciao");
        logger.info("test done: " + ret);
    }

}
