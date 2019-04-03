package com.yltx.proxy.proxyImp;

import com.yltx.proxy.IMath;

import java.util.Random;

//静态代理
public class MathProxy implements IMath {

    IMath math = new Math();

    @Override
    public int add(int n1, int n2) {
        long start = System.currentTimeMillis();
        lazy();
        int result = math.add(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    @Override
    public int sub(int n1, int n2) {
        long start = System.currentTimeMillis();
        lazy();
        int result = math.sub(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    @Override
    public int mut(int n1, int n2) {
        long start = System.currentTimeMillis();
        lazy();
        int result = math.mut(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    @Override
    public int div(int n1, int n2) {
        long start = System.currentTimeMillis();
        lazy();
        int result = math.div(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    public void lazy() {
        try {
            int n = new Random().nextInt(500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
