package org.javacore.rtti;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *  * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Jeff Lee
 * @since 2015-11-2 16:43:41
 * 	获取Class方法案例
 * 	toGenericString是Constructor,Method,Field这三个类专有的方法，
 * 	如Constructor类，给出的是对应的构造函数的细节，
 * 	比如修饰符，构造函数名和参数列表等
 */
public class ShowMethods {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("org.javacore.rtti.ShowMethods");
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            for (Method m : methods)
                System.out.println(m.toGenericString());
            for (Constructor constructor : constructors)
                System.out.println(constructor.toGenericString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
