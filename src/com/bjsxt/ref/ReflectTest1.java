package com.bjsxt.ref;

import com.bjsxt.ref.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 加载类信息至Class类对象
        Class<User> clz = (Class<User>) Class.forName("com.bjsxt.ref.bean.User");

        // 反射获取类信息
        String clzName1 = clz.getName();    // 包名+类名
        String clzName2 = clz.getSimpleName();  // 类名

        // 反射获取类属性
        Field idField = clz.getField("id");             // 私有不可获取 实际无法通过
        Field[] allFields = clz.getFields();
        Field nameField = clz.getDeclaredField("uname");// 私有可获取
        Field[] allFields2 = clz.getDeclaredFields();

        // 反射获取方法信息
        Method method1 = clz.getMethod("setAge", int.class);
        Method[] allMethod1 = clz.getMethods();
        Method method2 = clz.getDeclaredMethod("getUname", null);
        Method[] allMethod2 = clz.getMethods();
        //Method method3 = clz.getDeclaredMethod("testFunc", new Class[]{int.class, String.class});
        Method method3 = clz.getDeclaredMethod("testFunc", int.class, String.class);


        // 反射获取类对象
        User user1 = clz.newInstance();

        // 反射调用构造器
        Constructor<User> csr1 = clz.getDeclaredConstructor();
        Constructor<User> csr2 = clz.getDeclaredConstructor(int.class, String.class, int.class);

        User user2 = csr1.newInstance();
        User user3 = csr2.newInstance(1001, "wang", 21);

        // 反射操作属性和方法
        idField.setAccessible(true);
        idField.set(user3, 2002);
        System.out.println(user3.getId());

        method1.invoke(user3, 25);
        System.out.println(user3.getAge());

        method3.invoke(user3, 12, "hello");

    }
}
