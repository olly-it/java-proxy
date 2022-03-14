package it.olly.proxy.caller;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.olly.proxy.handler.GlobalServiceHandler;

@Component
public class GenericInvocationUtils {
    @Autowired
    private GlobalServiceHandler handler;

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> itf) {
        return (T) Proxy.newProxyInstance(itf.getClassLoader(), new Class[] { itf }, handler);
    }
}
