package top.inick.entity;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private Date birthday;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User(int id, String username, String password, String email, Date birthday) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
	}
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	
	
}
