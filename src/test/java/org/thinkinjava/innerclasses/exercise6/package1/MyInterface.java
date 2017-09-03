package org.thinkinjava.innerclasses.exercise6.package1;

/**
 * 练习六
 * 在第一个包中创建一个至少有一个方法的接口。
 * 然后在第二个包内创建一个类，
 * 在其中增加一个protected的内部类以实现那个接口。
 * 在第三个包中，继承这个类，并在一个方法中返回该protected内部类的对象，
 * 在返回的时候向上转型为第一个包中的接口的类型
 */
public interface MyInterface {
    void print();
}
