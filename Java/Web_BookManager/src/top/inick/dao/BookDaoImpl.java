package top.inick.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import top.inick.domain.Book;
import top.inick.util.C3P0Utils;

public class BookDaoImpl implements BookDao {
	
	/**
	 * 查询所有的图书
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findAllBooks() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
	}
	
	/**
	 * 添加图书
	 * @param book
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("INSERT INTO book(id, name, price, pnum, category, description) "
				+ "VALUES(?, ?, ?, ?, ?, ?)", book.getId(), book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription());
	
	}
	
	/**
	 * 根据id查找book
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Book findBookById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from Book where id=?", new BeanHandler<Book>(Book.class), id);
	}
	
	/**
	 * 修改图书信息
	 * @param book
	 * @throws SQLException
	 */
	public void updateBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?",
				book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(), book.getId());
		
	}
	
	/**
	 * 根据id删除book
	 * @param id
	 * @throws SQLException
	 */
	public void deleteBook(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("delete from book where id=?",id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @throws SQLException
	 */
	public void delAllBook(String[] ids) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		Object[][] params = new Object[ids.length][];
		for(int i = 0; i < params.length; i++) {
			params[i] = new Object[] {ids[i]};
		}
		qr.batch("delete from book where id=?", params);
	}

	/**
	 * 根据条件进行查询
	 * @param id
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	public List<Book> SearchBookServlet(String id, String name, String minprice, String maxprice, String category) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from book where 1=1";
		List list = new ArrayList();
		if(!"".equals(id)) {
			sql += " and id like ?";
			list.add("%"+id.trim()+"%");
		}
		if(!"".equals(name)) {
			sql += " and name like ?";
			list.add("%"+name.trim()+"%");
		}
		if(!"".equals(minprice)) {
			sql += " and price > ?";
			list.add(minprice.trim());
		}
		if(!"".equals(maxprice)) {
			sql += " and price < ?";
			list.add(maxprice.trim());
		}
		if(!"".equals(category)) {
			sql += " and category like ?";
			list.add("%"+category.trim()+"%");
		}
		System.out.println(list);
		return qr.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
		
		
	}
	
	/**
	 * 获取数据的总条数
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		long l = (long) qr.query("select count(id) from book", new ScalarHandler(1));
		return (int) l;
		
	}

	public List<Book> findBooks(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from book limit ?,?",new BeanListHandler<Book>(Book.class),(currentPage - 1) * pageSize, pageSize);
		
	}
}
