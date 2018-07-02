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

public class ShowCart  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//得到session
		HttpSession session = req.getSession();
		
		
		
		//从session中取出list（购物车）
		List<Book> list = (List<Book>) session.getAttribute("cart");
		System.out.println(list);
		if(list != null) {
			out.print("购物车有以下商品<br/>");
			for (Book book : list) {
				out.write(book.getName() + "<br/>");
			}
		} else {
			out.print("你还未添加任何商品<br/>");
			resp.setHeader("refresh", "2;url="+req.getContextPath()+"/session/showAllBooks");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
