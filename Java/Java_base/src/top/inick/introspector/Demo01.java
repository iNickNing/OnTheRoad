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
		// ���������� ,��Bean���е����Է�װ��BeanInfo������
		BeanInfo bf = Introspector.getBeanInfo(Student.class);
		//����������
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
		
		Method setter = pd.getWriteMethod();	//�õ�set����
		setter.invoke(stu, "tom");
		
		Method getter = pd.getReadMethod();
		System.out.println(getter.invoke(stu, null));
	}
	
	@Test
	public void test3() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student stu = new Student();
		PropertyDescriptor pd = new PropertyDescriptor("age", Student.class);
		
		Method setter = pd.getWriteMethod();	//�õ�set����
		setter.invoke(stu, 333);
		
		Method getter = pd.getReadMethod();
		System.out.println(getter.invoke(stu, null));
	}
	
	
}


