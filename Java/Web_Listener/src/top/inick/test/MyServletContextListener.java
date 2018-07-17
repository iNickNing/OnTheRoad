package top.inick.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//通过事件对象得到事件源
		ServletContext application = arg0.getServletContext();
		//创建一个集合存储session对象
		List<HttpSession> list = Collections.synchronizedList(new ArrayList<>());
		
		//吧集合放到application中
		application.setAttribute("sessions", list);

	}

}
