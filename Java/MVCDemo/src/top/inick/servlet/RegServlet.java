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
import top.inick.domain.UserForm;
import top.inick.exception.UserExistException;
import top.inick.service.UserService;
import top.inick.service.impl.UserServiceImpl;

public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//获取表单数据
		
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println(uf);
		if(!uf.validate()) {		//如果map不为空,说明有错误信息
			request.setAttribute("uf",uf);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}
		
		User user = new User();
		
			try {
				/*ConvertUtils.register(new Converter() {
					
					@Override
					public Object convert(Class type, Object value) {
						Date date1 = null;
						if(value instanceof String) {
							String date = (String) value;
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							try {
								sdf.parse(date);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							// TODO Auto-generated method stub
						}	
						
						return date1;
					}
				}, Date.class);*/
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.populate(user, request.getParameterMap());
				
				//调用业务逻辑
				UserService us = new UserServiceImpl();
				//检查用户名是否已注册
				us.findUserByName(user.getUsername());
				us.register(user);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserExistException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/reg.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		//分发转向
		response.getWriter().write("注册成功,1秒钟后跳转到主页");
		response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
