package top.inick.util;

import java.util.HashMap;
import java.util.Map;

import top.inick.entity.Book;

public class DBUtil {
	private static Map<String, Book> books = new HashMap<String, Book>();
	static {
		books.put("1", new Book("1","Java 基础", 90, "baibai"));
		books.put("2", new Book("2","Java 高级", 90, "baibai"));
		books.put("3", new Book("3","Java 多线程", 90, "baibai"));
		books.put("4", new Book("4","Java 高并发", 90, "baibai"));
		books.put("5", new Book("5","Java 编程艺术", 90, "baibai"));
		books.put("6", new Book("6","Java JVM", 90, "baibai"));
	}
	
	//得到所有的书
	public static Map<String, Book> findAllBooks() {
		return books;
	}
	
	/**
	 * 根据id查找指定书
	 * @param id
	 * @return
	 */
	public static Book findBookById(String id) {
		return books.get(id);
	}
	
}
