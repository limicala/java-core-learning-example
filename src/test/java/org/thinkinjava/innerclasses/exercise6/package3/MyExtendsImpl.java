package org.thinkinjava.innerclasses.exercise6.package3;

import org.thinkinjava.innerclasses.exercise6.package1.MyInterface;
import org.thinkinjava.innerclasses.exercise6.package2.MyInnerImpl;

public class MyExtendsImpl extends MyInnerImpl {


    public MyInterface returnInner (){
        return this.new MyInner();
    }
}
