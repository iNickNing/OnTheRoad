package top.inick.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import top.inick.entity.User;
import top.inick.util.C3P0Utils;

public class TestResultSetHandler {
	
	//@Test		//ArrayHandler 适合单行记录
	public void test01() throws SQLException {
		//创建一个QueryRunner 对象
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		Object[] arr = qr.query("select * from users", new ArrayHandler());	//没有条件则只读第一行
		
		for(Object o : arr) {
			System.out.println(o);
		}
	}
	
	//@Test		//ArrayListHandler 适用多行记录
	public void test2() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		List<Object[]> query = qr.query("select * from users", new ArrayListHandler());	//没有条件则只读第一行
		
		for (Object[] objects : query) {
			for(Object o : objects) {
				System.out.println(o);
			}
			System.out.println("----");
		}
		
	}
	
	//@Test		//ColumnListHandler 取某一列的数据
	public void test3() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		List<Object> list = qr.query("select * from users", new ColumnListHandler(2));	//没有条件则只读第一行
		
		for(Object o : list) {
			System.out.println(o);
		}

		
	}
	
	//@Test		//KeyedHandler 取多条记录,每一条记录分装到一个Map中,再把这个Map封装到另一个Map中,key为指定的字段值
	public void test4() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		//大Map的key是表中某项的数据,小Map中的key是表的列名,所以大Map的key是Object,小Map的key是Stirng类型
		Map<Object, Map<String, Object>> map = qr.query("select * from users", new KeyedHandler());	//没有条件则只读第一行
		
		for(Map.Entry<Object, Map<String, Object>> m : map.entrySet()) {
			System.out.println(m.getKey());
			for(Map.Entry<String, Object> mm : m.getValue().entrySet()) {
				System.out.println(mm.getKey() + mm.getValue());
			}
			System.out.println("--------------");
		}

	}
	
	@Test		//MapHandler 取一条记录,把记录和列名放在一个Map中
	public void test5() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		Map<String, Object> map = qr.query("select * from users", new MapHandler());	//没有条件则只读第一行
		for(Map.Entry<String, Object> m : map.entrySet()) {
			 System.out.println(m.getKey() + "--" + m.getValue());
		}
	}
	
	@Test		//MapListHandler 取多条记录,没条记录封装在Map中,再把Map封装在List中
	public void test6() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		List<Map<String, Object>> list = qr.query("select * from users", new MapListHandler());	//没有条件则只读第一行
		for (Map<String, Object> map : list) {
			for(Map.Entry<String, Object> m : map.entrySet()) {
				 System.out.println(m.getKey() + "--" + m.getValue());
			}
			System.out.println("------------");
		}
	}
	
	@Test		//ScalarHandler 取一条记录,单列记录
	public void test7() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		Object o = qr.query("select * from users", new ScalarHandler(2));	//没有条件则只读第一行
		System.out.println(o);
		System.out.println(o.getClass().getName());
	}
	
	@Test		//BeanHandler 取一条记录,用对象接收
	public void test8() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		User user = qr.query("select * from users", new BeanHandler<User>(User.class));	//没有条件则只读第一行
		System.out.println(user);
		System.out.println(user.getClass().getName());
	}
	
	@Test		//BeanListHandler 取一条记录,用对象接收
	public void test9() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
		//如果没有查到则是一个长度为0的list
		List<User> list = qr.query("select * from users", new BeanListHandler<User>(User.class));	//没有条件则只读第一行
		for (User user : list) {
			System.out.println(user);
		}
	}


}
