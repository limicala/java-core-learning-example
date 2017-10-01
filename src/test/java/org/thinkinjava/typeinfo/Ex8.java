package org.thinkinjava.typeinfo;

class AAA {}
class BBB extends AAA {}
class C1 extends BBB {}
public class Ex8 {
    public static void printInfo(Object o){
        if (o.getClass().getSuperclass() != null) {
            System.out.println(o.getClass() + "is a subclass of " + o.getClass().getSuperclass());

            try{
                printInfo(o.getClass().getSuperclass().newInstance());
            } catch(InstantiationException e) {
                System.out.println("Unable to instantiate obj");
            } catch(IllegalAccessException e) {
                System.out.println("Unable to access");
            }
        }
    }

    public static void main(String[] args) {
        C1 c = new C1();

        printInfo(c);
    }
}
