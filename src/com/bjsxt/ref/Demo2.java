package com.bjsxt.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo2 {
    public static void main(String[] args) throws NoSuchMethodException {
        String path = "com.bjsxt.ref.bean.User";
        try {
            Class clz = Class.forName(path);

            // 获取包名+类名
            System.out.println(clz.getName());

            // 获取类名
            System.out.println(clz.getSimpleName());

            // 获取属性信息
            System.out.println(clz.getFields().length);
            System.out.println(clz.getDeclaredFields().length);

            // 获取方法信息
            Method[] method1 = clz.getMethods();
            Method[] method2 = clz.getDeclaredMethods();
            System.out.println(method1.length);
            System.out.println(method2.length);
            Method method3 = clz.getMethod("setUname", String.class);
            for (Method method : method1) {
                System.out.println(method);
            }
            System.out.println("-------------------");
            for (Method method : method2) {
                System.out.println(method);
            }
            System.out.println("-------------------");
            // 获取构造器信息
            Constructor[] csr1 = clz.getConstructors();
            Constructor[] csr2 = clz.getDeclaredConstructors();
            for (Constructor constructor : csr1) {
                System.out.println(constructor);
            }
            System.out.println("-------------------");
            for (Constructor constructor : csr2) {
                System.out.println(constructor);
            }
            System.out.println("-------------------");
            Constructor csr3 = clz.getConstructor(int.class, String.class, int.class);
            System.out.println(csr3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
