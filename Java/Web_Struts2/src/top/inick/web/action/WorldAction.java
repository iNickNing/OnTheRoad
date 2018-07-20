package top.inick.web.action;

public class WorldAction {
	public String sayWorld() {
		System.out.println("WorldAction的sayWorld方法执行了");
		return "success";		//与配置文件中result的name取值相对应
	}
}
