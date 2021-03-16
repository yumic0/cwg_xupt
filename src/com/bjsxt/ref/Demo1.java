package com.bjsxt.ref;

import com.bjsxt.ref.bean.User;

public class Demo1 {
    public static void main(String[] args) {
        String path = "com.bjsxt.ref.bean.User";

        try {
            Class clz = Class.forName(path);
            System.out.println(clz);
            // 一个类被加载后, JVM会创建一个对应该类的Class对象
            // 类的整个结构信息会放到对应的Class对象
            // 通过这个Class对象可以看到类的全部信息
            System.out.println(clz.hashCode());
            Class clz2 = Class.forName(path);

            Class clz3 = com.bjsxt.ref.bean.User.class;
            User u1 = new User();
            Class clz4 = u1.getClass();

            System.out.println(clz2.hashCode());
            System.out.println(clz4==clz3);
            System.out.println(clz3.hashCode());
            System.out.println(clz4.hashCode());

            int[] arr1 = new int[100];
            int[] arr2 = new int[3];
            System.out.println(arr1.getClass()==arr2.getClass());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
}
