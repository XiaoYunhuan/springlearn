package com.yltx.spring;

import com.yltx.proxy.IMath;
import com.yltx.proxy.IMessage;
import com.yltx.proxy.proxyImp.Math;
import com.yltx.proxy.proxyImp.Message;
import javafx.application.Application;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test01()
    {
        //实例化Spring代理工厂
        ProxyFactory factory=new ProxyFactory();
        //设置被代理的对象
        factory.setTarget(new Math());
        //添加通知，横切逻辑
        factory.addAdvice(new BeforeAdvice());
        factory.addAdvice(new AfterAdvice());
        factory.addAdvice(new SurroundAdvice());
        //从代理工厂中获得代理对象
        IMath math=(IMath) factory.getProxy();
        int n1=100,n2=5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
    @org.junit.Test
    public void test02()
    {
        IMath math=(IMath) DynamicProxy.getProxy(new Math());
        int n1=100,n2=5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

    @org.junit.Test
    public void test03(){
        IMessage message = (IMessage) DynamicProxy.getProxy(new Message());
        message.message();
    }

    @org.junit.Test
    public void test04(){
        IMath math = new SpringProxy<IMath>().getProxyObject(new Math());
        int n1=100,n2=5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }


    @org.junit.Test
    public void test05(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        IMath math = (IMath) ctx.getBean("proxy");
        int n1=100,n2=5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}