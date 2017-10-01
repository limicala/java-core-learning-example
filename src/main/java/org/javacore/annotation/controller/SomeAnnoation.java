package org.javacore.annotation.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//public enum ElementType {
//    /**标明该注解可以用于类、接口（包括注解类型）或enum声明*/
//    TYPE,
//
//    /** 标明该注解可以用于字段(域)声明，包括enum实例 */
//    FIELD,
//
//    /** 标明该注解可以用于方法声明 */
//    METHOD,
//
//    /** 标明该注解可以用于参数声明 */
//    PARAMETER,
//
//    /** 标明注解可以用于构造函数声明 */
//    CONSTRUCTOR,
//
//    /** 标明注解可以用于局部变量声明 */
//    LOCAL_VARIABLE,
//
//    /** 标明注解可以用于注解声明(应用于另一个注解上)*/
//    ANNOTATION_TYPE,
//
//    /** 标明注解可以用于包声明 */
//    PACKAGE,
//
//    /**
//     * 标明注解可以用于类型参数声明（1.8新加入）
//     * @since 1.8
//     */
//    TYPE_PARAMETER,
//
//    /**
//     * 类型使用声明（1.8新加入)
//     * @since 1.8
//     */
//    TYPE_USE
//}

public interface SomeAnnoation {
}

@Target({ElementType.TYPE}) // for the type of class
@Retention(RetentionPolicy.RUNTIME)
@interface MyController {
    String value() default "";
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface RequestUrl {
    String url() default "";
}
