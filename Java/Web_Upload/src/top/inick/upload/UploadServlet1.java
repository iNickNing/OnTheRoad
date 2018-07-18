package top.inick.upload;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadServlet1
 */
public class UploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 由于表单提交数据的方式改为 multipart/form-data ,所以 getParamenter 拿不到值了
		 * String name = request.getParameter("name");
		String photoName= request.getParameter("photo");
		
		System.out.println(name);
		System.out.println(photoName);*/
		
		InputStream is = request.getInputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while((len=is.read(b)) != -1) {
			System.out.println(new String(b,0,len));
		}
		is.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
