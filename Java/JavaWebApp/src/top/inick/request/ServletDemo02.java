package top.inick.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		demo01(req);
//		demo02(req);
		String name  = req.getHeader("Accept");
		System.out.println(name);
		
	}

	private void demo02(HttpServletRequest req) {
		//获得所有请求消息的name
		Enumeration names = req.getHeaderNames();
		
		while(names.hasMoreElements()) {
			String e = (String) names.nextElement();
			System.out.println(e + "--" + req.getHeader(e));
		}
	}

	private void demo01(HttpServletRequest req) {
		//获取请求消息头的信息
		String header = req.getHeader("User-Agent");
		System.out.println(header);
		
//		if(header.toLowerCase().contains("msie")) {
//			System.out.println("IE浏览");
//		} else {
//			System.out.println(header.toLowerCase());
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
