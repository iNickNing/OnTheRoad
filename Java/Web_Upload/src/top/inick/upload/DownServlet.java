package top.inick.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownServlet
 */
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置要下载的文件
		String filename = "销售统计.csv";
		//设置文件名的编码
		if(request.getHeader("user-agent").toLowerCase().contains("msie")) {
			filename = URLEncoder.encode(filename, "UTF-8");
		} else {
			filename = new String(filename.getBytes("UTF-8"),"iso-8859-1"); //火狐浏览器
		}
		
		//告知浏览器要下载文件
		response.setHeader("content-disposition", "attachment;filename="+filename);
		response.setContentType(this.getServletContext().getMimeType(filename));
		
		response.setCharacterEncoding("GBK");	//每台电脑不一样
		
		//创建一个文件输出流
		PrintWriter out = response.getWriter();
		out.write("电脑,20\n");
		out.write("冰箱,40\n");
		out.write("洗衣机,30\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
