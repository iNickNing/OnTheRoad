package top.inick.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class Demo3Field {

	@Test
	public void test1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Student stu = new Student();
		Class clazz = Student.class;
		Field f = clazz.getField("name");
		Object o = f.get(stu);
		System.out.println(o);
		
		f.set(stu,"hhh");
		o = f.get(stu);
		System.out.println(o);
	}
	
	@Test
	public void test2() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Student stu = new Student();
		Class clazz = Student.class;
		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		f.set(stu, 44);
		Object o = f.get(stu);
		System.out.println(o);
	}
	
	@Test
	public void test3() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Student stu = new Student();
		Class clazz = Student.class;
		Field f = clazz.getDeclaredField("name");

		System.out.println(Modifier.toString(f.getModifiers()) +"\t"+ 
				f.getType().getSimpleName() +"\t"+ f.getName());
	}
	
	@Test
	public void test4() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Student stu = new Student();
		Class clazz = Student.class;
		//Field[] ff = clazz.getFields();
		Field[] ff = clazz.getDeclaredFields();
		System.out.println(ff.length);
	}
	
}
