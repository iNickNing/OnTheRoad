package top.inick.request;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import top.inick.entity.User;

public class ServletDemo03 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setStatus(404);
		//test01(req);
		

	}

	private void test04(HttpServletRequest req) throws UnsupportedEncodingException {
		try {
			//告诉服务器要使用什么编码,注:浏览器使用的是什么编码,传过来的就是什么编码
			req.setCharacterEncoding("UTF-8");
			User u = new User();
			System.out.println("封装前:" + u);
			
			BeanUtils.populate(u, req.getParameterMap());
			
			System.out.println("封装后:" + u);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test03(HttpServletRequest req) throws UnsupportedEncodingException {
		try {
			//告诉服务器要使用什么编码,注:浏览器使用的是什么编码,传过来的就是什么编码
			req.setCharacterEncoding("UTF-8");
			
			User u = new User();
			
			Map<String, String[]> parameterMap = req.getParameterMap();
			for (Entry<String, String[]> m : parameterMap.entrySet()) {
				String  name = m.getKey();
				String[] value = m.getValue();
				
				//创建一个属性描述器
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				//得到setter属性
				Method setter = pd.getWriteMethod();
				
				if(value.length == 1) {
					setter.invoke(u, value[0]);			//给一个变量赋值
				} else {
					setter.invoke(u, (Object)value);	//相当于高复选框赋值	
				} 
			}
			
			System.out.println(u);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test02(HttpServletRequest req) {
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] values = req.getParameterValues(name);
			for(int i = 0; values != null && i < values.length; i++) {
				System.out.println(name + "\t" + values[i]);
			}
			
			System.out.println("");
		}
	}

	private void test01(HttpServletRequest req) {
		String userName = req.getParameter("userName");
		String sex = req.getParameter("age");
		String[] hobbys = req.getParameterValues("hobbys");
		System.out.println(userName);
		System.out.println(sex);
		if(hobbys != null) {
			for(int i = 0; i < hobbys.length; i++) {
				System.out.println(hobbys[i]);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
