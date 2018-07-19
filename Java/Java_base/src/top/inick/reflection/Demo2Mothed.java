package top.inick.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo2Mothed {

	@Test
	public void test1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student stu = new Student();
		Class clazz = Student.class;
		Method m = clazz.getMethod("m1");
		m.invoke(stu, null);
	}
	
	@Test
	public void test2() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student stu = new Student();
		Class clazz = Student.class;
		Method m = clazz.getMethod("m2",String.class);
		m.invoke(stu, "tom");
	}
	
	@Test
	public void test3() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student stu = new Student();
		Class clazz = Student.class;
		Method m = clazz.getMethod("m3",String.class);
		Object o = m.invoke(stu, "tom");
		System.out.println(o);
	}
	
	@Test
	public void test4() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = Student.class;
		Method m = clazz.getDeclaredMethod("m4",int.class);
		m.setAccessible(true);
		Object o = m.invoke(clazz.newInstance(), 34);
		System.out.println(o);
	}
	
	@Test
	public void test5() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = Student.class;
		Method m = clazz.getMethod("m5",String.class,int.class);
		Object o = m.invoke(null,"tom", 34);
		System.out.println(o);
	}
	
	@Test
	public void test6() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = Student.class;
		Method m = clazz.getMethod("m6",String[].class);
		Object o = m.invoke(null, new Object[]{new String[]{"tom", "jack"}});
		
	}
	@Test
	public void test7() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = Student.class;
		Method[] m = clazz.getMethods();
		System.out.println(m.length);
	}
	
	@Test
	public void test8() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = Student.class;
		Method[] m = clazz.getDeclaredMethods();	//包括本类公共的私有的,但不包括继承的 
		System.out.println(m.length);
	}
}
