# 代理模式

代理模式的作用是：

为其他对象提供一种代理以控制对这个对象的访问。
在某些情况下，一个客户不想或者不能直接引用另一个对象，
而代理对象可以在客户端和目标对象之间起到中介的作用。

代理分静态代理和动态代理
使用场景可以看[链接](https://www.zhihu.com/question/20794107)

# 静态代理
在调用真实角色的方法前或调用方法后执行一些操作，类似于AOP切面编程

因此，一个真实角色类对应一个代理角色类


# 动态代理
静态代理会导致代码量的增大，且许多代理类都是类似的

使用方法：
- 编写一个动态代理类，实现InvocationHandler接口的invoke方法，

当代理类生成的代理对象执行真实角色类实现的接口的方法时，
会调用invoke方法来实现

    // 真实对象
    Hello hello = new HelloImpl();
    // 动态代理对象
    DynamicProxy proxy = new DynamicProxy(hello);
    // 使用Proxy的newProxyInstance方法来生成代理对象
    Hello helloproxy = (Hello) Proxy.newProxyInstance(
        hello.getClass().getClassLoader(),
        hello.getClass().getInterfaces(),
        proxy
    );
    // 调用Hello接口里面的方法
    helloproxy.say("aa");
    
    
# 问题

### Proxy的newProxyInstance是如何生成一个代理对象的？

jdk1.8 Proxy 详情看[链接](http://blog.csdn.net/bluetjs/article/details/52263410)

大概的步骤：
1. newProxyInstance提供类装载器和一组接口类
    Proxy.newProxyInstance(
            hello.getClass().getClassLoader(),
            hello.getClass().getInterfaces(),
            proxy
        );
2. 在newProxyInstance方法中的部分代码
    /* 
    * 获得与指定类装载器和一组接口相关的代理类类型对象 
    */  
    Class<?> cl = getProxyClass0(loader, intfs);  
    ... ... ...
    //获取代理对象的构造方法（也就是$Proxy0(InvocationHandler h)）   
    final Constructor<?> cons = cl.getConstructor(constructorParams);  
    ... ... ...
    //生成代理类的实例并把动态代理对象（也就是上面的proxy对象）的实例传给它的构造方法  
    return cons.newInstance(new Object[]{h});  

3. 在测试模块将生成的class文件保存，使用jd-jui反编译工具得到内部的say实现方法
    private static Method m4;  
    public final String SayHello(String paramString)  
    {  
        try  
        {  
          return (String)this.h.invoke(this, m4, new Object[] { paramString });  
        }  
        catch (Error|RuntimeException localError)  
        {  
          throw localError;  
        }  
        catch (Throwable localThrowable)  
        {  
          throw new UndeclaredThrowableException(localThrowable);  
        }  
    }
  因此，可知在调用接口的方法时，生成的代理对象会去执行invoke方法
  
# CGlib动态代理
Java本身动态代理是基于接口去生成的，所以无法代理没有实现接口的类。

而CGLib生成代理是基于类去生成的，
即直接采用继承的方式生成委托类的子类，然后覆写相应的业务方法。
不过这样的话，对于final来修改的类无法利用CGLib生成动态代理对象

# 相关链接

[Java 动态代理机制分析及扩展，第 1 部分]https://www.ibm.com/developerworks/cn/java/j-lo-proxy1/

[彻底理解JAVA动态代理]http://www.cnblogs.com/flyoung2008/archive/2013/08/11/3251148.html

[Java 动态代理作用是什么？]https://www.zhihu.com/question/20794107

[Java JDK 动态代理使用及实现原理分析]http://blog.csdn.net/bluetjs/article/details/52263410

**[JDK动态代理实现原理](http://rejoy.iteye.com/blog/1627405)**

[Cglib的使用方法(1)--Enhancer](http://www.cnblogs.com/icejoywoo/archive/2011/06/05/2072970.html)






