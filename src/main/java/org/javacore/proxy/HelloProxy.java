package org.javacore.proxy;

/**
 * 静态代理
 */
public class HelloProxy implements Hello{
    private Hello hello;

    public HelloProxy(){
        hello = new HelloImpl();
    }

    public void before(){
        System.out.println("Before");
    }

    public void after(){
        System.out.println("After");
    }

    @Override
    public String say(String name) {
        before();
        hello.say("wu");
        after();
        return "";
    }
}
