package top.inick.web.action;

import com.opensymphony.xwork2.Action;

/**
 * 第二种动作类创建方法
 * 		创建一个普通类实现Action接口,是想接口中的方法
 * @author iNick
 *
 */
public class Demo2Action implements Action {

	
	/**
	 * Action接口的常量
	 * 		SUCCESS "success"	执行成功前往指定位置
	 * 		NONE	"nome"		不返回热呢结果识图,return null 是一样的
	 * 		ERROR	"error"		当执行的方法出现异常之后,前往指定位置
	 * 		INPUT	"input"		数据回显
	 * 		LOGIN	"login"		一般用于返回登录页面
	 */
	public String execute() throws Exception {
		return null;
	}

}
