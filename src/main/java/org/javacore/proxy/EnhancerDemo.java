package org.javacore.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 学习使用cglib里面的Enhancer类
 */
public class EnhancerDemo {
    public static void main(String[] args) {
        // 创建一个增强类enhancer对象，用于生成代理类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(A.class);
        // 设置invoke方法
        enhancer.setCallback(new MethodInterceptorImpl());

        A demo = (A) enhancer.create();

        demo.aa();
        System.out.println(demo.bb());
//        System.out.println(demo.cc());
    }


    private static class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            before();
            Object result = methodProxy.invokeSuper(o, objects);
            after();
            return result;
        }

        public void before() {
            System.out.println("Before");
        }

        public void after() {
            System.out.println("After");
        }
    }
}

class A{
    public void aa(){
        System.out.println("aa");
    }

    public String bb(){
        return "bb";
    }

    private String cc(){
        return "cc";
    }
}
