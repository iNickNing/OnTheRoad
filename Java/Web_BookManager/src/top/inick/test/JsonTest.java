package top.inick.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import top.inick.domain.Book;
import top.inick.util.C3P0Utils;

public class JsonTest {
	@Test	//封装成json对象
	public void test01() {
		Book book = new Book();
		book.setName("小玩意");
		book.setPnum(90);
		
		String s = JSONObject.fromObject(book).toString();
		System.out.println(s);
	}
	@Test	//封装成json数组
	public void test02() {
		Book book = new Book();
		book.setName("小玩意");
		book.setPnum(90);
		Book book1 = new Book();
		book.setName("小玩意");
		book.setPnum(90);
		List<Book> list = new ArrayList<>();
		list.add(book1);
		list.add(book);
		
		String s = JSONArray.fromObject(list).toString();
		System.out.println(s);
	}
	
	@Test	//利用JsonConfig,取出指定不需要的字段
	public void test03() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		List<Book> list = qr.query("select * from book", new BeanListHandler<Book>(Book.class));
		
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(new String[] {"pnum","description"});
		String s = JSONArray.fromObject(list,jc).toString();
		System.out.println(s);
	}
}