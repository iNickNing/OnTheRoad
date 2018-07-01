package top.inick.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.inick.entity.Book;
import top.inick.util.DBUtil;


public class ShowAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("本网站有以下好书<br/>");
		Map<String, Book> books = DBUtil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.write("<a href='"+request.getContextPath()
			+"/cookie/showBookDetail?id="+book.getKey()
			+"' target='_blank'>"+book.getValue().getName()
			+"</a><br/>");
		}
		
		
		out.write("您最近浏览过的书<br/>");
		Cookie[] cookies = request.getCookies();
		for(int i = 0; cookies != null && i < cookies.length; i++) {
			if("historyBookId".equals(cookies[i].getName())) {
				String value = cookies[i].getValue();
				String[] ids = value.split("-");
				for(int j = 0; j < ids.length; j++) {
					Book book = DBUtil.findBookById(ids[j]);
					out.print(book.getName() + "<br/>");
				}
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
