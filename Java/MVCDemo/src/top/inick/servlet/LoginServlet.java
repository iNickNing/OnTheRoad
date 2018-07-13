package top.inick.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import top.inick.domain.User;
import top.inick.service.UserService;
import top.inick.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//获取表单数据
		User user = new User();
		try {
			
			BeanUtils.populate(user, request.getParameterMap());
			//调用业务逻辑
			UserService us = new UserServiceImpl();
			User u = us.login(user);
			//分发转向
			if(u != null) {
				//如果登录成功,把user对象放到session对象
				request.setAttribute("u", user);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {	//登录失败则调回登录页面
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
