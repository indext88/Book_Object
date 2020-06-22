package cn.edu.svtcc.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import cn.edu.svtcc.test.interfacee.BookDao;
import cn.edu.svtcc.test.pojo.BookDo;

public class BookDaoimpl implements BookDao {
	// 调用jdbc
//	private DataBase ds;

	DataSource ds;

	public BookDaoimpl() {
		// 直接调用FristBookObjectListener中的DataSourceProvider的方法内容
		ds = DataSourceProvider.getinstance().getDataSource();

//		try {
//			//1.得到一个运行环境
//			Context ctx=new InitialContext();
//			//2.调用lookup查找组件(java:comp/env/+组件名)
//			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbpooling");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public BookDo getBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		BookDo bookdo = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM books WHERE ISBN=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, isbn);
			rs = stat.executeQuery();
			// 把rs中的每一行转换成一个Users对象

			while (rs.next()) {
				bookdo = new BookDo();
				// 得到BookDo表中的每一列的名字
				bookdo.setId(rs.getInt(1));
				bookdo.setTitle(rs.getString(2));
				bookdo.setAuthor(rs.getString(3));
				bookdo.setPublisherId(rs.getInt(4));
				bookdo.setPublishDate(rs.getString(5));
				bookdo.setIsbn(rs.getString(6));
				bookdo.setWordsCount(rs.getInt(7));
				bookdo.setUntiPrice(rs.getFloat(8));
				bookdo.setContentDescription(rs.getString(9));
				bookdo.setAurhorDescription(rs.getString(10));
				bookdo.setEditorComment(rs.getString(11));
				bookdo.setToc(rs.getString(12));
				bookdo.setCategorId(rs.getInt(13));
				bookdo.setClicks(rs.getInt(14));
//				把bookdo对象加到集合里
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 调用关闭数据库的操作
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bookdo;
	}

	@Override
	public List<BookDo> listBooksByTitle(String title) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<BookDo> booklist = new ArrayList<BookDo>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM books WHERE title LIKE '%" + title + "%' or author like '%" + title + "%' ";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			// 把rs中的每一行转换成一个Users对象
			while (rs.next()) {
				BookDo bookdo = new BookDo();
				// 得到BookDo表中的每一列的名字
				bookdo.setId(rs.getInt(1));
				bookdo.setTitle(rs.getString(2));
				bookdo.setAuthor(rs.getString(3));
				bookdo.setPublisherId(rs.getInt(4));
				bookdo.setPublishDate(rs.getString(5));
				bookdo.setIsbn(rs.getString(6));
				bookdo.setWordsCount(rs.getInt(7));
				bookdo.setUntiPrice(rs.getFloat(8));
				bookdo.setContentDescription(rs.getString(9));
				bookdo.setAurhorDescription(rs.getString(10));
				bookdo.setEditorComment(rs.getString(11));
				bookdo.setToc(rs.getString(12));
				bookdo.setCategorId(rs.getInt(13));
				bookdo.setClicks(rs.getInt(14));
//				把bookdo对象加到集合里
				booklist.add(bookdo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 调用关闭数据库的操作
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return booklist;
	}

	/**
	 * 查询所有图书
	 */
	@Override
	public List<BookDo> listbook() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<BookDo> booklist = new ArrayList<BookDo>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM books";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			// 把rs中的每一行转换成一个Users对象
			while (rs.next()) {
				BookDo bookdo = new BookDo();
				// 得到BookDo表中的每一列的名字
				bookdo.setId(rs.getInt(1));
				bookdo.setTitle(rs.getString(2));
				bookdo.setAuthor(rs.getString(3));
				bookdo.setPublisherId(rs.getInt(4));
				bookdo.setPublishDate(rs.getString(5));
				bookdo.setIsbn(rs.getString(6));
				bookdo.setWordsCount(rs.getInt(7));
				bookdo.setUntiPrice(rs.getFloat(8));
				bookdo.setContentDescription(rs.getString(9));
				bookdo.setAurhorDescription(rs.getString(10));
				bookdo.setEditorComment(rs.getString(11));
				bookdo.setToc(rs.getString(12));
				bookdo.setCategorId(rs.getInt(13));
				bookdo.setClicks(rs.getInt(14));
//				把bookdo对象加到集合里
				booklist.add(bookdo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 调用关闭数据库的操作
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return booklist;
	}

	@Override
	public List<BookDo> listBooksByCagtegoryId(int id) {
		// TODO Auto-generated method stub
		List<BookDo> booklist = new ArrayList<BookDo>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		BookDo bookdo = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from books where CategoryId like '%" + id + "%'";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			// 把rs中的每一行转换成一个Users对象
			while (rs.next()) {
				bookdo = new BookDo();
				// 得到BookDo表中的每一列的名字
				bookdo.setId(rs.getInt(1));
				bookdo.setTitle(rs.getString(2));
				bookdo.setAuthor(rs.getString(3));
				bookdo.setPublisherId(rs.getInt(4));
				bookdo.setPublishDate(rs.getString(5));
				bookdo.setIsbn(rs.getString(6));
				bookdo.setWordsCount(rs.getInt(7));
				bookdo.setUntiPrice(rs.getFloat(8));
				bookdo.setContentDescription(rs.getString(9));
				bookdo.setAurhorDescription(rs.getString(10));
				bookdo.setEditorComment(rs.getString(11));
				bookdo.setToc(rs.getString(12));
				bookdo.setCategorId(rs.getInt(13));
				bookdo.setClicks(rs.getInt(14));
				// 把bookdo对象加到集合里
				booklist.add(bookdo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return booklist;
	}

}
