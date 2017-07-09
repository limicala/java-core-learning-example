package org.javacore.rtti;

/**
 * 通过静态初始化块->初始化age
 * 通过初始化块->　　初始化sex
 * 通过构造方法->    初始化name
 */
public class LearnStatic {
    String name;
    String sex;
    static int age;

    // 构造方法
    public LearnStatic(){
        System.out.println("constructor part");
        name = "wu";
    }

    // 初始化块
    {
        System.out.println("initial part");
        sex = "male";
    }

    // static initial part
    static {
        System.out.println("static initial part");
        age = 18;
    }

    public void print(){
        System.out.println("name:"+ name);
        System.out.println("sex:"+ sex);
        System.out.println("age:"+ age);
    }

    public static void main(String[] args){
        LearnStatic hello = new LearnStatic();
        LearnStatic hello2 = new LearnStatic();
//        hello.print();
    }
}
