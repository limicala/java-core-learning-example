package org.thinkinjava.typeinfo;

import org.thinkinjava.typeinfo.interfacea.A;

import static org.thinkinjava.typeinfo.HiddenImplementation.callHiddenMethod;

class InnerA {
    private static class C implements A {
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
    }

    public static A makeA() { return new C(); }
}
public class InnerImplementation {
    public static void main(String[] args) throws Exception{
        A a = InnerA.makeA();
        a.f();

        callHiddenMethod(a, "g");

        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
}
