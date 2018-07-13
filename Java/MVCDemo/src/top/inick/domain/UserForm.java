package top.inick.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserForm {
	private int id;
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	
	Map<String, String> msg = new HashMap<>();
	/*用户名：必须输入，且3~8位的字母组成<br>
	密码：必须输入，3~8位的数组组成<br>
	确认密码：和密码保持一致<br>
	邮箱：必须输入，且要符合邮箱的格式<br>
	生日：必须输入，符合yyyy-MM-dd的格式<br>*/
 
	public boolean validate() {
		
		if("".equals(this.username)) {
			msg.put("username", "用户名不可为空");
		} else if (!username.matches("\\w{3,8}")) {
			msg.put("username", "用户名为3~8的字母组成");
		}
		
		if ("".equals(this.password)) {
			msg.put("password", "密码不可为空");
		} else if (!password.matches("\\d{3,8}")) {
			msg.put("password", "密码为3~8的数字组成");
		}
		if(!this.repassword.equals(this.password)) {
			msg.put("repassword", "两次密码不一致");
		}
		
		if("".equals(this.email)) {
			msg.put("email", "邮箱不可为空");
		} 
		
		if("".equals(this.birthday)) {
			msg.put("birthday", "生日不可为空");
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(this.birthday);
			} catch (ParseException e) {
				msg.put("birthday", "生日格式不正确");
				e.printStackTrace();
			}
		}
		
		return msg.isEmpty();	//当map集合中没有数据是返回true
		
	}
	
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Map<String, String> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", username=" + username + ", password=" + password + ", repassword=" + repassword
				+ ", email=" + email + ", birthday=" + birthday + ", msg=" + msg + "]";
	}
	
	
}
