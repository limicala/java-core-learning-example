package org.jee.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 描述:RPC测试代码类
 * Created by bysocket on 16/2/29.
 */
public class RpcTest {
    public static void main(String[] args) {
        // 启动服务提供者
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost",8088);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 创建服务本地代理
        RpcImporter<EchoService> importer = new RpcImporter<>();

        // 从服务本地代理获取服务对象类
        // 这里importer的第一个参数是实现类的类，
        // 因为这个例子本质上是让服务提供者通过动态代理产生一个实现类的对象
        // 然后通过socket传递ObjectInputStream并转成对象
        // 但是我理解的rpc是消费者只要知道接口类，服务者会返回这个接口的实现类
        // 所以这个例子真正涉及到rpc的只是不多
        EchoService echo = importer.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8088));
        System.out.println(echo.echo("Are you OK?"));
    }
}
