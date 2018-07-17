package top.inick.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import top.inick.domain.User;
import top.inick.service.UserService;

public class AutoLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//1.转换两个对象
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		req = new MyRequest(req);
		
		String requestURI = req.getRequestURI(); 
		String path = req.getContextPath();
//		System.out.println(path);
		path = requestURI.substring(path.length());
//		System.out.println(requestURI);
//		System.out.println(path);
		
		if(!("/login.jsp".equals(path) || "/loginServlet".equals(path))) {
			System.out.println("!11111111111111111111111111112");
			User user = (User) req.getSession().getAttribute("user");
			if(user == null) {	//如果用户没有登录过,我们才执行自动登录
				
				//2.处理业务
				//得到cookie数组
				Cookie[] cookies = req.getCookies();
				//从数组中找到想要的user对象信息
				Cookie cookie = null;
				String username = "";
				String password = "";
				for(int i = 0; cookies != null && i < cookies.length; i++) {
					if("user".equals(cookies[i].getName())) {
						cookie = cookies[i];
						String value = cookie.getValue(); //tom&123
						String[] values = value.split("&");
						username = values[0];
						password = values[1];
					}
				}
		
				UserService us = new UserService();
				User u = us.findUser(username, password);
				//如果登录成功,把用户信息存到session中
				if(u != null) {
					req.getSession().setAttribute("user", user);
				}
			}
		}
		//3.放行
		arg2.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

class MyRequest extends HttpServletRequestWrapper {
	HttpServletRequest request;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	/*@Override
	public String getParameter(String name) {
		name = request.getParameter(name);
		try {
			return new String(name.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	
	@Override
	public String getParameter(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name)[0];
	}
	private boolean flag = true;
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap(); //乱码
		if(flag) {
			for(Map.Entry<String, String[]> m : map.entrySet()) {
				String[] values = m.getValue();
				for(int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		flag = false;
		}
		return map;
	}
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name);
	}
	
	
	
	
}
