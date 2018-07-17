package top.inick.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener,Serializable,HttpSessionActivationListener{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("user绑定了");
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("user解除绑定了");
		
	}
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("活化");
		
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("钝化");
	}
	
}
