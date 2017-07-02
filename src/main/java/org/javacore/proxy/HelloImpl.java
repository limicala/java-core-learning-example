package org.javacore.proxy;

public class HelloImpl implements Hello {
    @Override
    public String say(String name) {
        System.out.println("Hello" + name);
        return name;
    }
}
