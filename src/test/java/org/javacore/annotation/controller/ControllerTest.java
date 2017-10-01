package org.javacore.annotation.controller;

import org.javacore.annotation.Todo;
import org.javacore.util.ClassUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ControllerTest {

    public static void scan(){
        Set<Class<?>> classSet = ClassUtil.getClassSet("org.javacore.annotation");


        for(Class<?> clazz : classSet) {
            RequestUrl aa = (RequestUrl) clazz.getAnnotation(RequestUrl.class);
            if (aa != null) System.out.println(aa.url());
            for(Method method : clazz.getMethods()){
                MyController controllerAnno = (MyController) method.getAnnotation(MyController.class );

                if (controllerAnno != null) {
                    System.out.println(" Method Name : " + method.getName());
                    System.out.println(controllerAnno.value());
                }

                RequestUrl requestUrl = (RequestUrl) method.getAnnotation(RequestUrl.class);

                if (requestUrl != null){
                    System.out.println("Method Name : " + method.getName());
                    System.out.println(requestUrl.url());
                }

            }
        }
    }

    public static void invokeTest() throws Exception{
        Class clazz = IndexController.class;

        Object object = clazz.newInstance();

        Method method1 = clazz.getMethod("aa");

        System.out.println(method1.invoke(object));

        Method method2 = clazz.getMethod("bb");

        System.out.println(method2.invoke(object).toString());
    }

    public static void main(String[] args) throws Exception {

        // 扫描
        Set<Class<?>> classSet = ClassUtil.getClassSet("org.javacore.annotation");
        Map<String, Action> actionMap = new HashMap<String, Action>();
        for(Class<?> clazz : classSet) {
            MyController controllerAnno = (MyController) clazz.getAnnotation(MyController.class );

            if (controllerAnno != null) {
                Object object = clazz.newInstance();
                RequestUrl prefix = (RequestUrl) clazz.getAnnotation(RequestUrl.class);
                String pre = "/";
                if (prefix != null) pre = prefix.url();

                for(Method method : clazz.getMethods()){

                    RequestUrl requestUrl = (RequestUrl) method.getAnnotation(RequestUrl.class);

                    if (requestUrl != null){
                        System.out.println("Method Name : " + method.getName());
                        String url = requestUrl.url();

                        // 存入Action
                        String finalUrl = pre + "/" + url;
                        Action action = new Action(method, object);

                        actionMap.put(finalUrl, action);
                    }

                }
            }


        }

        Set<String> set = actionMap.keySet();
        for(String s : set){
            actionMap.get(s).invokeMethod();
        }
        // 接收请求并调用Action的方法
    }
}
