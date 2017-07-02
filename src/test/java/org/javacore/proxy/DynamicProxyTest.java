package org.javacore.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args){
        Hello hello = new HelloImpl();
        DynamicProxy proxy = new DynamicProxy(hello);

        Hello helloproxy = (Hello) Proxy.newProxyInstance(
            hello.getClass().getClassLoader(),
            hello.getClass().getInterfaces(),
            proxy
        );
        helloproxy.say("aa");
    }
}
