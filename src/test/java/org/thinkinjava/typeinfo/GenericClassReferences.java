package org.thinkinjava.typeinfo;

import java.lang.reflect.Field;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;

        // 使用泛型限制Class引用指向的类型只能为Integer类，此处还包括包装类
        Class<Integer> genericIntClass = intClass;
        genericIntClass = Integer.class;

        intClass = double.class;
//        genericIntClass = double.class; 出错
    }
}
