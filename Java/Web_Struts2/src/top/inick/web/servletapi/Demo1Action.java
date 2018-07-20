package top.inick.web.servletapi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取ServletAPI
 * 	第一种方式:
 * 		使用的事ServletActionContext的对象	推荐
 * 	第二种
 * 		使用依赖注入的方式,将我们想要的对象注入
 * @author iNick
 *
 */
public class Demo1Action extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Override
	public String execute() throws Exception {
		
		/*HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		*/

		System.out.println(request);
				
		System.out.println(response);
		
		return null;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
}
