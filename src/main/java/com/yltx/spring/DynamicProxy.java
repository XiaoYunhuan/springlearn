package com.yltx.spring;

import org.springframework.aop.framework.ProxyFactory;

public abstract class DynamicProxy {
    public static Object getProxy(Object object){

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(object);
        factory.addAdvice(new TimeSpanAdvice());
        return factory.getProxy();
    }
}
