package org.javacore.base.String; /*
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
 * @author BYSocket
 * @since 2016-01-06 20:07:00
 * 对象含有String作为方法参数传递
 */
public class StringT2 {

    public static void main(String[] args) {
        StringObject sb = new StringObject();
        sb.setName("123");
        change(sb, sb);
        System.out.println(sb.getName()); //结果为 234
    }

    public static void change(StringObject sb1, StringObject sb2) {
        /**
         * 在这里可以看出对象作为方法传递，只是传递该对象的一个引用，相当于指针
         * sb1指向了一个新申请的对象
         * sb2引用没有变，只是修改了对象的name属性
         */
        sb1 = new StringObject();
        sb1.setName("456");
        sb2.setName("234");
    }

}
class StringObject {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
