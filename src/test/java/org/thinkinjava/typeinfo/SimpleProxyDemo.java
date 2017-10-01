package org.thinkinjava.typeinfo;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse" + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface anInterface;

    public SimpleProxy(Interface anInterface){
        this.anInterface = anInterface;
    }
    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        anInterface.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse");
        anInterface.somethingElse(arg);
    }
}
public class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("banana");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
