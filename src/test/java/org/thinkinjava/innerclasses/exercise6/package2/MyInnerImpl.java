package org.thinkinjava.innerclasses.exercise6.package2;

import org.thinkinjava.innerclasses.exercise6.package1.MyInterface;

public class MyInnerImpl {

    protected class MyInner implements MyInterface{

        public MyInner(){}

        @Override
        public void print() {
            System.out.println("MyInner.print()");
        }
    }
}
