package com.yltx.proxy.proxyImp;

import com.yltx.proxy.IMessage;

public class Message implements IMessage {
    @Override
    public void message() {
        System.out.println("Hello AOP");
    }
}
