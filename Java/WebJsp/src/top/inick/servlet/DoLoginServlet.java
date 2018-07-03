package top.inick.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoLoginServlet
 */
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取表单数据
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		//处理业务逻辑
		if("tom".equals(username) && "123".equals(pwd)) {
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("msg", "用户名或密码错误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		//分发转向
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
