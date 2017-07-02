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


