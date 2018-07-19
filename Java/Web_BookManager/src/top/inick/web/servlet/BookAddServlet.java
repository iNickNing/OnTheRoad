package top.inick.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import top.inick.domain.Book;
import top.inick.service.BookServiceImpl;
import top.inick.util.UUIDUtil;

/**
 * Servlet implementation class BookAddServlet
 */
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//创建 DiskFileItemFactory
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建ServletFileUpload对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");
		//解析request对象,返回所有表单项
		List<FileItem> fileItems = null;
		Map<String, String[]> map = new HashMap<String, String[]>();
		
		try {
			fileItems = sfu.parseRequest(request);
			//迭代fileItem表单项
			for(FileItem item : fileItems) {
				if(item.isFormField()) {	//普通表单项
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					map.put(name, new String[]{value});
					
				} else {	//文件表单项
					InputStream inputStream = item.getInputStream();
					String fileName = item.getName();
					String extension = FilenameUtils.getExtension(fileName);
					if(!"jsp".equals(extension) || "exe".equals(extension)) {
						File storeDirectory = new File(this.getServletContext().getRealPath("/upload"));
						if(!storeDirectory.exists()) {	//if file doesn't exists, create directory
							storeDirectory.mkdirs();
						}
						String childDirectory = makeChildDirectory(storeDirectory, fileName);
						fileName = childDirectory + File.separator + fileName;
						// written to the disk
						item.write(new File(storeDirectory,fileName));
						item.delete();	//delete temporary file
						
					}
					map.put(item.getFieldName(), new String[]{fileName});	//Save the form items to the map
				}
			}
			//获取book对象
			Book book = new Book();
			
			//将传过来的参数填写到book
			BeanUtils.populate(book, map);
			book.setId(UUIDUtil.getUUID());
			
			//调用业务逻辑.将书存进去
			BookServiceImpl bsi = new BookServiceImpl();
			bsi.addBook(book);
					
			//分发转向
			request.getRequestDispatcher("BookListServlet").forward(request, response);
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*request.setCharacterEncoding("UTF-8");
		BookServiceImpl bsi = new BookServiceImpl();
		
		//获取book对象
		Book book = new Book();
		try {
			//将传过来的参数填写到book
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtil.getUUID());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//调用业务逻辑.将书存进去
		bsi.addBook(book);
		
		//分发转向
		request.getRequestDispatcher("BookListServlet").forward(request, response);
	*/}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//对目录进行打散
		private String makeChildDirectory(File storeDirectory, String filename) {
			
			//拿到文件名的32hashcode码
			int hashcode = filename.hashCode();
			//将hashcode转换为16进值的字符
			String code = Integer.toHexString(hashcode);
			//构建新的目录	目前最多可以构成16*16个文件目录,也可以继续增加,
			String childDirectory = code.charAt(0) + File.separator +
					code.charAt(1);
			//创建指定目录
			File file = new File(storeDirectory, childDirectory);
			if(!file.exists()) {
				file.mkdirs();
			}
			return childDirectory;
		}

}
