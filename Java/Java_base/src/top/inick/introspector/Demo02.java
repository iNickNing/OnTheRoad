package top.inick.introspector;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;


public class Demo02 {
	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student stu = new Student();
		//BeanUtils默认支持八种数据类型转换
		BeanUtils.setProperty(stu, "name", "张三");
		String s = BeanUtils.getProperty(stu, "name");
		System.out.println(s);
	}
	
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student stu = new Student();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(stu, "birthday", "2009-09-09");
		String s = BeanUtils.getProperty(stu, "birthday");
		
		System.out.println(s);
	}
	
	@Test
	public void test3() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student stu = new Student();
		ConvertUtils.register(new Converter() {
			
			@Override
			public Object convert(Class arg0, Object value) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if(value instanceof String) {
					String v = (String) value;
					try {
						return sdf.parse(v);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				
				return null;
			}
		}, Date.class);
		BeanUtils.setProperty(stu, "birthday", "2017-09-09");
		String s = BeanUtils.getProperty(stu, "birthday");
		
		System.out.println(s);
	}
	@Test
	public void test4() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map m = new HashMap();
		m.put("name", "李白"); //key一定要和对象的属性一致
		m.put("age", "34");
		m.put("birthday", "1998-09-08");
		
		Student stu = new Student();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(stu, m);	//将map属性自动放到Bean中
		String s = BeanUtils.getProperty(stu, "birthday");
		
		System.out.println(s);
	}
}
