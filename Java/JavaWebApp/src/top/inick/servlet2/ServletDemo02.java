package top.inick.servlet2;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDemo02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDemo02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/21.png");
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = response.getOutputStream();
		
		//获取要下载的文件名
		String filename = path.substring(path.lastIndexOf("\\")+1);
		//设置文件名的编码
		filename = URLEncoder.encode(filename, "UTF-8");
		//告知浏览器要下载文件
		response.setHeader("content-disposition", "attachment;filename="+ filename);
		//设置内容的类别
		response.setHeader("content-type", "image/png");
		
		int len = 1;
		byte[] b = new byte[1024];
		while((len = fis.read(b)) != -1) {
			sos.write(b, 0, len);
		}
		
		sos.close();
		fis.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
