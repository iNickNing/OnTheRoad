package top.inick.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import top.inick.domain.Book;
import top.inick.service.BookServiceImpl;

/**
 * Servlet implementation class FindProductName
 */
public class FindProductName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProductName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		
		BookServiceImpl bs = new BookServiceImpl();
		List<Object> list = bs.searchBookByName(name);
		
		/*//把集合中的数据转换成字符串
		String str = "[";
		for(int i = 0; i < list.size(); i++) {
			if(i > 0) {
				str += ",";
			}
			str += "\"" + list.get(i) + "\"";
		}
		str += "]";*/
		
		//把数据响应到客户端
		response.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
