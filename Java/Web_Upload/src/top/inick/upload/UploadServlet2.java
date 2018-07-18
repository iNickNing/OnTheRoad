package top.inick.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class UploadServlet2
 */
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//要执行文件上传的操作
		//判断表单是否支持文件的上传,
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if(!isMultipartContent) {
			throw new RuntimeException("you form is not multipart/form-data");
		}
		//创建一个DiskFileItemfactory工厂类
		DiskFileItemFactory factory =  new DiskFileItemFactory();
		factory.setRepository(new File("D:\\"));
		//创建一个ServletFileUpload核心对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 解决上传表单项乱码问题
		sfu.setHeaderEncoding("UTF-8");
		
		try {
			//设置上传文件的大小
			// sfu.setFileSizeMax(1024*1024*3);//表示3M大小
			// sfu.setSizeMax(1024*1024*6);
			//解析request对象
			List<FileItem> fileItems = sfu.parseRequest(request);
			for(FileItem fileitem : fileItems) {
				if(fileitem.isFormField()) {
					//处理普通表单项
					processFormField(fileitem);
				} else {
					processUploadField(fileitem);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//文件表单项
	private void processUploadField(FileItem fileitem) {
		// DONE 保存文件
		try {
			//拿到上传文件的名字
			String filename = fileitem.getName();
			if(filename == null || "".equals(filename)) {	//没上传文件就不存了
				return;
			}
			//得到输入流
			InputStream is = fileitem.getInputStream();
			
			//创建文件存储的目录
			String directoryRealPath = "D:\\upload";
			File storeDirectory = new File(directoryRealPath);
			if(!storeDirectory.exists()) {	//当文件不存在时新建
				storeDirectory.mkdirs();
			}
			
			if(filename != null) {
				filename = FilenameUtils.getName(filename);
			}
			
			//解决重名问题
			filename = UUID.randomUUID() + "_" + filename;
			//防止太多文件放在一个文件夹,这里对文件目录进行打散(分发)
			String childDirectory = makeChildDirectory(storeDirectory, filename);
			//保存文件
			fileitem.write(new File(storeDirectory, childDirectory + File.separator + filename));
			//清除缓存文件
			fileitem.delete();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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

	//普通表单项
	private void processFormField(FileItem fileitem) {
		try {
			String fieldname = fileitem.getFieldName();	//字段名
			String fieldvalue = fileitem.getString("UTF-8");	//字段值
			System.out.print(fieldname + "=" + fieldvalue);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 按日期打散
		/*
		 * private String makeChildDirectory(File storeDirectory) {
		 * 
		 * SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd"); String
		 * dateDirectory = sdf.format(new Date()); //只管创建目录 File file = new
		 * File(storeDirectory,dateDirectory); if(!file.exists()){ file.mkdirs(); }
		 * 
		 * return dateDirectory; }
		 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
