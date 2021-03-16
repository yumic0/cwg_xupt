package com.bjsxt.ref;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.bjsxt.ref.annotation.SxtField;
import com.bjsxt.ref.annotation.SxtMethod;
import com.bjsxt.ref.annotation.SxtTable;

/**
 * 通过反射获取注解信息
 * * @author 尚学堂高淇
 *
 */
public class Demo5 {
	public static void main(String[] args) {

		try {
			Class clazz = Class.forName("com.bjsxt.ref.annotation.SxtStudent");

			//获得类的所有有效注解
			Annotation[] annotations=clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			//获得类的指定的注解
			SxtTable st = (SxtTable) clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());

			//获得类的属性的注解
			Field f = clazz.getDeclaredField("studentName");
			SxtField sxtField = f.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());

			//获得类的方法的注解
			Method mtd1 = clazz.getDeclaredMethod("setAge", int.class);
			SxtMethod sxtMethod = mtd1.getAnnotation(SxtMethod.class);
			System.out.println("sxtMethod.mtdName(): "+sxtMethod.mtdName());
			System.out.println("sxtMethod.returnName(): "+sxtMethod.returnName());
			System.out.println("sxtMethod.paramType(): "+sxtMethod.paramType());
			for (String s : sxtMethod.paramType()) {
				System.out.println(s);
			}
			System.out.println("sxtMethod.returnType(): "+sxtMethod.returnType());
			//根据获得的表名、字段的信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库中生成相关的表

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
}
