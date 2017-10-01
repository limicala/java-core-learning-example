package org.thinkinjava.typeinfo;

import org.thinkinjava.typeinfo.interfacea.A;

import static org.thinkinjava.typeinfo.HiddenImplementation.callHiddenMethod;

class AnonymousA {
    public static A makeA() {
        return new A() {
            @Override
            public void f() {
                System.out.println("public C.f()");
            }

            public void g() {
                System.out.println("public C.g()");
            }

            void u() {
                System.out.println("package C.u()");
            }

            protected void v() {
                System.out.println("protected C.v()");
            }

            private void w() {
                System.out.println("private C.w()");
            }
        };
    }
}
public class AnonymousImplementation {
    public static void main(String[] args) throws Exception{
        A a = AnonymousA.makeA();
        a.f();

        callHiddenMethod(a, "g");

        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
}
