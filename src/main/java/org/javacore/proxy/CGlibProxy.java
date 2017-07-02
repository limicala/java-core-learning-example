package org.javacore.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy implements MethodInterceptor {

    private static CGlibProxy instance = new CGlibProxy();

    private CGlibProxy(){}

    public static CGlibProxy getInstance(){
        return instance;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(obj, args);
        after();
        return result;
    }

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }

    public static void main(String[] args){
        Hello helloProxy = CGlibProxy.getInstance().getProxy(HelloImpl.class);
    }


    public void before(){
        System.out.println("Before");
    }

    public void after(){
        System.out.println("After");
    }
}
