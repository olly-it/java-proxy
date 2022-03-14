package it.olly.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GlobalServiceHandler implements InvocationHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext context;

    private Method findMethod(String methodName, Object object, Class<?> iface) {
        Method[] met = object.getClass()
                .getMethods();
        for (Method m : met) {
            if (m.getName()
                    .equals(methodName)) {
                logger.info("found method: " + m);
                return m;
            }
        }
        logger.info("no method found for: " + methodName);
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        logger.info("global service handler's got invocation");
        // NOTE! do not invoke anything of proxy (neither a toString), otherwise it would cause an infinite loop
        // invocation
        logger.info("method: " + method);
        logger.info("args: " + Arrays.asList(args));

        Object bean = context.getBean(method.getDeclaringClass());
        Method findMethod = findMethod(method.getName(), bean, method.getDeclaringClass());

        return findMethod.invoke(bean, args);
    }
}