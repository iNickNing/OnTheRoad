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


public class ServletDemo04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDemo04() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setIntHeader("refresh", 1);
		Random r = new Random();
		response.getWriter().write(r.nextInt() + "");*/
		
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh", "3;url=/JavaWebApp/servlet2/demo03");
		response.getWriter().write("三秒之后跳转");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
