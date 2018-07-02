package top.inick.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.inick.entity.Book;
import top.inick.util.DBUtil;

public class ShowAllBooksServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("本店所有的书<br/>");
		
		Map<String, Book> books = DBUtil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.print("<a href='"+req.getContextPath()
			+"/session/addCart?id="+book.getKey()
			+"'>"+book.getValue().getName()
			+"</a><br/>");
		}
		out.print("<hr/>");
		out.print("<a href='"+
		req.getContextPath()+"/session/showCart'>查看购物车<a/>");
		out.print("sessionid" + req.getSession().getId());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
