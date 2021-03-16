package com.bjsxt.ref;

import com.bjsxt.ref.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

/**
 *
 * 通过反射API操作： 构造器、方法、属性
 *
 */
public class Demo3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        String path = "com.bjsxt.ref.bean.User";

        try {
            // 反射获取类
            Class<User> clz = (Class<User>) Class.forName(path);
            User u = clz.newInstance();         // 调用无参构造器
            System.out.println(u);

            // 反射获取构造器
            Constructor<User> csr = clz.getDeclaredConstructor(int.class, String.class, int.class);
            User u2 = csr.newInstance(1001, "牛逼",18);
            System.out.println(u2.getUname());

            // 通过反射API调用普通方法
            User u3 = clz.newInstance();
            Method method1 = clz.getDeclaredMethod("setUname", String.class);
            method1.invoke(u3, "123");
            System.out.println(u3.getUname());

            // 通过反射API操作属性
            User u4 = new User();
            Field f = clz.getDeclaredField("uname");
            f.setAccessible(true);      // 属性不用做安全检查,可以直接访问
            f.set(u4, "搞起耍");
            System.out.println(u4.getUname());
            System.out.println(f.get(u4));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
