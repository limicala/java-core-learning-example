package org.javacore.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 相关链接：(文章中的java版本可能比较老，但是只看关键代码也可以
 * https://www.ibm.com/developerworks/cn/java/j-lo-proxy1/
 *
 * http://www.cnblogs.com/flyoung2008/archive/2013/08/11/3251148.html
 *
 * https://www.zhihu.com/question/20794107
 *
 * jdk1.8
 * http://blog.csdn.net/bluetjs/article/details/52263410
 * 看这个http://rejoy.iteye.com/blog/1627405
 * 生成代理对象是用的Proxy类的静态方法newProxyInstance
 *
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    /**
     * 生成代理对象
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
            target.getClass().getInterfaces(), this);
    }

    public void before(){
        System.out.println("Before");
    }

    public void after(){
        System.out.println("After");
    }
}
