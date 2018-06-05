package top.inick.servlet2;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDemo05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDemo05() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("准备重定向");
		/*response.setStatus(302);
		response.setHeader("location", "/JavaWebApp/servlet2/demo03");*/
		
		response.sendRedirect("/JavaWebApp/servlet2/demo03");
		
		System.out.println("已转");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
