package com.yltx.proxy;

import com.yltx.proxy.proxyImp.DynamicProxy;
import com.yltx.proxy.proxyImp.DynamicProxyCglib;
import com.yltx.proxy.proxyImp.Math;
import com.yltx.proxy.proxyImp.MathProxy;

public class Test {
    @org.junit.Test
    public void test01(){
        //IMath math = new MathProxy();   //静态dialing
        //IMath math = (IMath) new DynamicProxy().getProxyObject(new Math()); //jdk动态代理
        IMath math = (IMath) new DynamicProxyCglib().getProxyObject(new Math()); //cglib动态代理
        int n1 = 100, n2 = 5;
        math.add(n1,n2);
        math.sub(n1,n2);
        math.mut(n1,n2);
        math.div(n1,n2);

    }
}
