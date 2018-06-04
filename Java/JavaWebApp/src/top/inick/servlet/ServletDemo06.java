package top.inick.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private Enumeration<String> initParameterNames;
	
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		/*this.config = config;*/
	}

	public ServletDemo06() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Demo06 Served at: ").append(request.getContextPath());
		/*String encoding = config.getInitParameter("encoding");
		System.out.println("" + encoding);*/
		
		//String encoding = this.getServletConfig().getInitParameter("encoding");
		/*String encoding = this.getInitParameter("encoding");
		System.out.println("" + encoding);*/
		
		initParameterNames = this.getServletContext().getInitParameterNames();
		while(initParameterNames.hasMoreElements()) {
			System.out.println(initParameterNames.nextElement());
		}
		//System.out.println("" + initParameterNames);
		/*ServletContext application = this.getServletContext();
		
		String name = (String) application.getAttribute("name");
		System.out.println(name);*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
