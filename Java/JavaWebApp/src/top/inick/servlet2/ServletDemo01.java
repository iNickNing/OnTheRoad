package top.inick.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		//告诉服务端使用UTF-8解析文本
		resp.setCharacterEncoding("UTF-8");
		//告诉浏览器使用什么编码
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		*/
		//相当于处理了上面两条语句
		resp.setContentType("text/html;charset=UTF-8");
		
		/*PrintWriter out = resp.getWriter();
		out.write("你好!");*/
		
		ServletOutputStream outputStream = resp.getOutputStream();
		outputStream.write("你好啊".getBytes("UTF-8"));//默认编码为本地编码
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

	
	
}
