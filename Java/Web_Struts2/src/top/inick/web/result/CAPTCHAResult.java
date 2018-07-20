package top.inick.web.result;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import cn.dsna.util.images.ValidateCode;

/**
 * 自定义结果类型
 * 第一步: 写一个普通类,继承自StrutsResultSupport,并且重写doExecute方法
 * @author iNick
 *
 */
public class CAPTCHAResult extends StrutsResultSupport {
	
	private int width;
	private int height;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	protected void doExecute(String arg0, ActionInvocation arg1) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 使用第三方生成验证码的jar包
		 * 	1.拷贝ValidateCode.jar到工程lib目录
		 * 	2.创建ValidateCode的对象
		 * 	3.获取对象输出流
		 * 	4.输出到浏览器
		 */
		
		//设置参数
		ValidateCode code = new ValidateCode(width,height,4,10);
		//获取响应对象
		HttpServletResponse response = ServletActionContext.getResponse();
		//输出到浏览器
		code.write(response.getOutputStream());
		
	}

}
