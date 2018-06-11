package top.inick.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo03 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String[] hobbys = req.getParameterValues("hobbys");
		System.out.println(name);
		System.out.println(sex);
		if(hobbys != null) {
			for(int i = 0; i < hobbys.length; i++) {
				System.out.println(hobbys[i]);
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
