package top.inick.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDemo07() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext application = this.getServletContext();
		/*application.setAttribute("name", "tom");
		String name = (String) application.getAttribute("name");
		System.out.println(name);*/
		//String path = application.getRealPath("/WEB-INF/a.properties");
		String path = application.getRealPath("/WEB-INF/classes/b.properties");
//		System.out.println(path);
		//创建一个Properties
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));
		System.out.println(pro.getProperty("key"));
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
