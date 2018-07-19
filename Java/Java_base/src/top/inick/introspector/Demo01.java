package top.inick.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo01 {
	
	@Test
	public void test1() throws IntrospectionException {
		// 对象描述器 ,将Bean所有的属性分装到BeanInfo对象中
		BeanInfo bf = Introspector.getBeanInfo(Student.class);
		//属性描述器
		PropertyDescriptor[] pds = bf.getPropertyDescriptors();
		
		System.out.println(pds.length);
		
		for(PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}
	
	@Test
	public void test2() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student stu = new Student();
		PropertyDescriptor pd = new PropertyDescriptor("name", Student.class);
		
		Method setter = pd.getWriteMethod();	//得到set方法
		setter.invoke(stu, "tom");
		
		Method getter = pd.getReadMethod();
		System.out.println(getter.invoke(stu, null));
	}
	
	@Test
	public void test3() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student stu = new Student();
		PropertyDescriptor pd = new PropertyDescriptor("age", Student.class);
		
		Method setter = pd.getWriteMethod();	//得到set方法
		setter.invoke(stu, 333);
		
		Method getter = pd.getReadMethod();
		System.out.println(getter.invoke(stu, null));
	}
	
	
}


