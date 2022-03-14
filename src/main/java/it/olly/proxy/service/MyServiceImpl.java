package it.olly.proxy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyServiceInterface {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AnotherService anotherService;

    @Override
    public String getName() {
        String ret = "bomber";
        logger.info("getName() -> " + ret);
        anotherService.log(); // test if anotherService is autowired when invoking me by reflection
        return ret;
    }

    @Override
    public void empty() {
        logger.info("empty()");
        anotherService.log(); // test if anotherService is autowired when invoking me by reflection
    }

    @Override
    public Integer doSomething(String input) {
        int ret = (int) (Math.random() * 100000);
        logger.info("doSomething (" + input + ") -> " + ret);
        anotherService.log(); // test if anotherService is autowired when invoking me by reflection
        return ret;
    }

}
