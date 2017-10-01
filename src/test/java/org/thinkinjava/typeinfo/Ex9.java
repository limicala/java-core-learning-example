package org.thinkinjava.typeinfo;

import java.lang.reflect.Field;

class AA { int a;}
class BB extends AA {int b;}
class CC extends BB {int c;}
public class Ex9 {
    public static void printInfo(Object o){
        Class cl = o.getClass();
        Field[] fields = cl.getDeclaredFields();
        if (fields != null){
            for (Field field : fields){
                System.out.println(field);
            }
        }
        if (cl.getSuperclass() != null) {

            try{
                printInfo(cl.getSuperclass().newInstance());
            } catch(InstantiationException e) {
                System.out.println("Unable to instantiate obj");
            } catch(IllegalAccessException e) {
                System.out.println("Unable to access");
            }
        }
    }

    public static void main(String[] args) {
        CC cc = new CC();

        printInfo(cc);
    }
}

