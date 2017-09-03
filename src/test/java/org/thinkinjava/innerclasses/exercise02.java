package org.thinkinjava.innerclasses;

/**
 * 练习2
 * 创建一个类，它持有一个String，并且有一个显示这个String的toString()方法。
 * 将你的新类的若干个对象添加到一个Sequence对象中，然后显示它们。
 */
class StringObject {
    public String name;

    public StringObject(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
public class exercise02 {

    public static void main(String[] args) {
        Sequence sequence = new Sequence(5);

        for(int i = 0; i < 5; i++){
            sequence.add(new StringObject("obj" + i));
        }

        Selector selector = sequence.selector();

        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
    }
}
