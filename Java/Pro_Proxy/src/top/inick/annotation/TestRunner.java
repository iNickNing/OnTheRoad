package top.inick.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//查看测试类中的方法,哪个有@MyTest就执行哪个方法
//		test01();
		Class clazz = SomeDaoImpl.class;
		Method[] methods = clazz.getMethods();
		for(Method m : methods) {
			
			//得到当前方法上的注解对象
			MyTest myTest = m.getAnnotation(MyTest.class);
			if(myTest != null) {	//如果有注解,测试执行时间
				long timeout = myTest.timeout();//得到注解的属性值
				if(timeout < 0) {	//不测试
					m.invoke(clazz.newInstance(), null);
				} else {
					long l1 = System.nanoTime();
					m.invoke(clazz.newInstance(), null);
					long l2 = System.nanoTime();
					if((l2 - l1) > timeout) {
						System.out.println(m.getName()+"方法超时");
					}
				}
			} 
		}
		
		
	}

	private static void test01() throws IllegalAccessException, InvocationTargetException, InstantiationException {
		
		
		//得到要执行的类的Class对象
		Class clazz = SomeDaoImpl.class;
		
		//得到类中的方法
		Method[] methods = clazz.getMethods();
		
		//遍历错有方法
		for(Method m : methods) {
			/*boolean flag = m.isAnnotationPresent(MyTest.class);
			System.out.println(m.getName() + "-" + flag);*/
			if(m.isAnnotationPresent(MyTest.class)) {
				m.invoke(clazz.newInstance(),null);
			}
		}
	}

}
