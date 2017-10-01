package org.javacore.annotation;

import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args) {
        Class clazz = UserAnnotationMethod.class;

        for(Method method : clazz.getMethods()){
            Todo todoAnnotation = (Todo) method.getAnnotation(Todo.class );

            if (todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
            }
        }
    }


}
