package org.thinkinjava.innerclasses;

/**
 * 练习五
 * 创建一个包含内部类的类，
 * 在另一个独立的类中，创建此内部类的实例
 */
class OutA{
    class InnerA{
        void print(){
            System.out.println("--------");
        }
    }
}
public class exercise05 {
    public static void main(String[] args) {
        OutA outA = new OutA();

        OutA.InnerA oia = outA.new InnerA();

        oia.print();
    }
}
