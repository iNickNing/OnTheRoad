package top.inick.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo01 implements Servlet{

	//Servlet生命周期方法
	//在servlet第一次访问时被调用
	//实例化
	public ServletDemo01() {
		System.out.println("----------初始化------------");
	}
	
	//Servlet生命周期方法
	//应用被卸载的时候被调用
	//销毁
	@Override
	public void destroy() {
		System.out.println("----------destroy------------");
		
	}

	
	//Servlet生命周期方法
	//第一次访问时被调用
	//初始化
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("----------init------------");
		
	}

	//Servlet生命周期方法
	//每次调用都调用
	//服务
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("----------service------------");
		System.out.println("Hello Servlet");
	}
	
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}


}
