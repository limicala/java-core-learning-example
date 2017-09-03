package org.thinkinjava.others;

import org.junit.Test;

public class Learn1 {

    /**
     * 测试基本类型的==
     */
    @Test
    public void test01(){
        int a = 1;
        long b = 1;
        double c = 1;
        System.out.println(a == b);
        System.out.println(a == c);
    }

    @Test
    public void test02(){
        Integer a = 1;
        Double b = 1.0;
        Long c = 1L;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }

    @Test
    public void test03(){
        Integer a = 1;
        Integer b = new Integer(1);
        Integer c = new Integer(1);
        System.out.println("a.equals(b) : " + a.equals(b));
        System.out.println("a == b      : " + (a == b));
        System.out.println("b.equals(c) : " + b.equals(c));
        System.out.println("b == c      : " + (b == c));
    }
}
