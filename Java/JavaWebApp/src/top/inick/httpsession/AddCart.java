package top.inick.httpsession;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.inick.entity.Book;
import top.inick.util.DBUtil;

public class AddCart  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//根据id得到书
		String id = req.getParameter("id");
		Book book = DBUtil.findBookById(id);
		//得到session
		HttpSession session = req.getSession();
		
		//从session中取出list（购物车）
		List<Book> list = (List<Book>) session.getAttribute("cart");
		
		if(list == null) {
			list = new ArrayList<Book>();
		}
		list.add(book);
		
		session.setAttribute("cart", list);
		
		out.print("添加成功，2秒返回<br/>");
		resp.setHeader("refresh", "2;url="+req.getContextPath()+"/session/showAllBooks");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
