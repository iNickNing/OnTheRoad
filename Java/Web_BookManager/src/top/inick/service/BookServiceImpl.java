package top.inick.service;

import java.sql.SQLException;
import java.util.List;

import top.inick.dao.BookDaoImpl;
import top.inick.domain.Book;
import top.inick.domain.PageBean;

public class BookServiceImpl {
	//创建一个Dao对象
	BookDaoImpl bookDao = new BookDaoImpl();
	
	public List<Book> findAllBooks() {
		try {
			return bookDao.findAllBooks();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addBook(Book book) {
		try {
			bookDao.addBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Book findBookById(String id) {
		try {
			Book book = bookDao.findBookById(id);
			return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteBook(String id) {
		try {
			bookDao.deleteBook(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delAllBook(String[] ids) {
		try {
			bookDao.delAllBook(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Book> SearchBookServlet(String id, String name, String minprice, String maxprice, String category) {
		// TODO Auto-generated method stub
		try {
			return bookDao.SearchBookServlet(id, name, minprice, maxprice, category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据当前页和分页大小获得PageBean对象
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean findBooksPage(int currentPage, int pageSize) {
		try {
			int count = bookDao.getCount();
			int totalPage = (int) Math.ceil(count * 1.0 / pageSize);
			List<Book> books = bookDao.findBooks(currentPage, pageSize);
			
			//创建BookPage对象,并一一赋值
			PageBean pb = new PageBean();
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setCount(count);
			pb.setTotalPage(totalPage);
			pb.setBooks(books);
			
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
