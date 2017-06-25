package org.javacore.base.copy;

/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Jeff Lee
 * @since 2015-11-16 13:53:51
 *  深拷贝与浅拷贝
 */
class Family implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 深拷贝
     * @return
     */
    /*@Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }*/
}
class Student implements Cloneable{
    private String name;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    /**
     * 浅拷贝 对其对象的引用却没有拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深拷贝
     */
    /*@Override
    protected Object clone() {
        Student o = null;
        try {
            o = (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        o.family = (Family) family.clone();
        return o;
    }*/
}

/**
 * Cloneable有段注释：
 * Therefore, it is not possible to clone an object merely by virtue of the
 * fact that it implements this interface.  Even if the clone method is invoked
 * reflectively, there is no guarantee that it will succeed.
 * 翻译：
 * 因此，如果只是继承这个接口是不可能克隆一个对象的。即使这个clone方法因为反射而被调用，
 * 仍无法保证能够克隆成功。
 *
 * 关于Clonable这个接口在知乎上的问答：https://www.zhihu.com/question/35240637
 *
 * 类Object里的clone方法访问控制符为protected，
 * 即只能被同一包中的类以及子类访问
 *
 * clone方法还有native关键字，即该方法是通过调用相关的dll文件执行一些较底层的工作
 * 具体看文章链接：http://www.2cto.com/kf/201706/644810.html
 * 文章里提到，当子类要使用父类的native方法时，
 * 无法直接调用父类的方法，而是要重写这个方法并交给父类去执行，像这样：
   @Override
   protected Object clone() throws CloneNotSupportedException {
        return super.clone();
   }
 * java的类型，java的类型分为两大类，
    * 一类为primitive，如int，
    * 另一类为引用类型,如String,Object等等。
    * java的引用类型都是存储在堆上的。
 * 然后开始说这份代码说的内容
 * 1. 浅拷贝： 只是将调用该方法的对象另复制一份，使用一段新的内存来存放，
    * 但是在这个对象里面类级别的属性还是引用
 * 2. 深拷贝： 克隆该对象后再克隆对象所引用的类级别的属性，重新引用这些属性
 *
 */
public class CopyT {
    public static void main(String[] args) throws CloneNotSupportedException {
        Family family = new Family();
        family.setName("Jeff Family");
        Student student1 = new Student();
        student1.setFamily(family);
        student1.setName("Jeff");

        Student student2 = (Student) student1.clone();
        student2.setName("Jeff2");
        student2.getFamily().setName("Jeff2 Family");
        System.out.println(student1.getName() + " " + student1.getFamily().getName());
        System.out.println(student2.getName() + " " + student2.getFamily().getName());
    }
}
