package top.inick.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//获取客户端保存的最后访问时间
		Cookie[] cookies = req.getCookies();//获取所有的cookie
		for(int i = 0; cookies != null && i < cookies.length; i++) {//遍历
			if("LastAccessTime".equals(cookies[i].getName())) {//找到最后访问的时间的cookieName
				long l = Long.parseLong(cookies[i].getValue());//拿到值,转换为long型的数据
				out.write("你最后访问的时间为:" + new Date(l).toLocaleString());//输出
			}
		}
		
		//创建cookie,并把信息写到客户端
		Cookie ck = new Cookie("LastAccessTime", System.currentTimeMillis() + "");
		//将Cookie写回客户端
		resp.addCookie(ck);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
