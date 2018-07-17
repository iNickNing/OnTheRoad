package top.inick.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.inick.domain.User;
import top.inick.service.UserService;
import top.inick.util.MD5Utils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		password = MD5Utils.md5(password);
		
		System.out.println(username);
		System.out.println(request.getParameter("username"));
		
		UserService us = new UserService();
		User user = us.findUser(username, password);
		
		if(user != null) {
			String rememberme = request.getParameter("rememberme");
			Cookie cookie = new Cookie("user", user.getUsername()+"&"+user.getPassword());
			cookie.setPath("/");
			if(rememberme != null) { //把用户信息存入cookie
				cookie.setMaxAge(60*60*24*7);
			} else { //清楚cookie数据
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
