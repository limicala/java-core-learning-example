package org.javacore.annotation;


public class UserAnnotationMethod {

    @Todo(priority = Todo.Priority.MEDIUM, author = "Wurenjie")
    public void method1(){

    }

    @Author("aaa")
    public void method2(){

    }
}
