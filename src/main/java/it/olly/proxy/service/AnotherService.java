package it.olly.proxy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnotherService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void log() {
        logger.info("simple log to test autowire");
    }
}
