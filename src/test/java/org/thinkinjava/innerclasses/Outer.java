package org.thinkinjava.innerclasses;

/**
 * 练习1
 * 编写一个名为Outer的类，它包含一个名为Inner的类。
 * 在Outer中添加一个方法，它返回一个Inner类型的对象。
 * 在main()中，创建并初始化一个指向某个Inner对象的引用。
 */

public class Outer {

    class Inner {

    }
    public Inner inners(){
        return new Inner();
    }

    public static void main(String[] args) {
        // 先创建外部类对象
        Outer outer = new Outer();

        Outer.Inner inner = outer.inners();
    }
}
