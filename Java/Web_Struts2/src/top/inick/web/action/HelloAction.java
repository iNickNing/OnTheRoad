package top.inick.web.action;

public class HelloAction {	//动作类
	
	/**
	 * 在动作类中指定的动作方法
	 * 动作方法的书写要求
	 * 	1.都是public
	 * 	2.返回值必须是String
	 * 	3.必须没有参数
	 * @return
	 */
	public String sayHello() {
		System.out.println("HelloActiond的sayHello方法执行了");
		return "success";		//与配置文件中result的name取值相对应
	}
}
