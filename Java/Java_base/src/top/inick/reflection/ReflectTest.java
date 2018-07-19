package top.inick.reflection;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class ReflectTest {

	public static void main(String[] args) throws Exception {
		Student stu = (Student) m1("top.inick.reflection.Student");
		stu.show();
		
	}
	
	private static Object m1(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class clazz = Class.forName(className);
		return clazz.newInstance();
	}

	@Test
	public void test2() throws InstantiationException, IllegalAccessException {
		//Class clazz = Class.forName("top.inick.reflection.Student");
		//Class clazz = Student.class;
		Student stu = new Student();
		Class clazz = stu.getClass();
		Student stu1 = (Student) clazz.newInstance();
		System.out.println(stu1.equals(stu));
	}
	
	@Test
	public void test3() throws Exception {
		Class clazz = Class.forName("top.inick.reflection.Student");
		Constructor c = clazz.getConstructor(null);
		c.newInstance();
	}
	
	@Test
	public void test4() throws Exception {
		Class clazz = Class.forName("top.inick.reflection.Student");
		//Constructor c = clazz.getConstructor(String.class);
		Constructor c = clazz.getConstructor(String.class);
		c.newInstance("ddd");
	}
	
	@Test
	public void test5() throws Exception {
		Class clazz = Class.forName("top.inick.reflection.Student");
		Constructor c = clazz.getDeclaredConstructor(Integer.class);
		c.setAccessible(true);
		c.newInstance(44);
	}
	
	@Test
	public void test6() throws Exception {
		Class clazz = Class.forName("top.inick.reflection.Student");
		Constructor c = clazz.getConstructor(String.class,int.class);
		c.newInstance("gg", 44);
	}
	
	@Test
	public void test7() throws Exception {
		Class clazz = Class.forName("top.inick.reflection.Student");
		Constructor[] c = clazz.getConstructors();
		System.out.println(c.length);
	}
	
	@Test
	public void test8() throws Exception {
		Class clazz = Class.forName("top.inick.reflection.Student");
		Constructor[] c = clazz.getDeclaredConstructors();
		System.out.println(c.length);
	}
}
