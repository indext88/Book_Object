package cn.edu.svtcc.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import cn.edu.svtcc.test.pojo.BookDo;
import cn.edu.svtcc.test.pojo.PayDao;

public class PayBookimpl {
	DataSource ds;

	public PayBookimpl() {
		ds = DataSourceProvider.getinstance().getDataSource();
	}

//	private DataBase ds;

	/***
	 * 购物车的删除
	 * 
	 * @param name
	 * @return
	 */
	public boolean getTitl(String name) {
		// TODO Auto-generated method stub
		BookDo bookdo = null;
		Connection conn = null;
		PreparedStatement stat = null;
		int rs = 0;
		try {
			conn = ds.getConnection();
			String sql = "delete from paybook where Bname=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			rs = stat.executeUpdate();
			// 把rs中的每一行转换成一个Users对象
			if (rs > 0) {
				return true;
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

		return false;
	}

	/***
	 * 数据插入
	 * 
	 * @param name
	 * @param num
	 * @param price
	 * @param sumprice
	 * @return
	 */
	public boolean Payinsert(String name, Integer num, Double price, Double sumprice) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
//			conn=DataBase.getConnectiob();
			conn = ds.getConnection();
			String sql = "insert into paybook(Bname,num,Bprice,Sumprice)" + "values(?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			stat.setInt(2, num);
			stat.setDouble(3, price);
			stat.setDouble(4, sumprice);
			// 设置？的值
			int mm = stat.executeUpdate();
			// 判断是否存在
			if (mm > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// 调用关闭数据库的操作
//			DataBase.release(rs,stat,conn);
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	/***
	 * 购物车查询
	 * 
	 * @return
	 */
	public List<PayDao> listPay() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<PayDao> booklist = new ArrayList<PayDao>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM paybook";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			// 把rs中的每一行转换成一个Users对象
			while (rs.next()) {
				PayDao bookdo = new PayDao();
				// 得到BookDo表中的每一列的名字
				bookdo.setBname(rs.getString(2));
				bookdo.setNum(rs.getInt(3));
				bookdo.setPrice(rs.getDouble(4));
				bookdo.setSumprice(rs.getDouble(5));
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

	/***
	 * 数量的修改
	 * 
	 * @param name
	 * @param num
	 * @return
	 */

	public boolean addnum(Integer num, Double sumprice, String name) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
//			conn=DataBase.getConnectiob();
			conn = ds.getConnection();
			String sql = "update paybook set num=?,sumprice=? where Bname=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, num);
			stat.setDouble(2, sumprice);
			stat.setString(3, name);
			System.out.println(num);
			System.out.println(sumprice);
			System.out.println(name);
			// 设置？的值
			int mm = stat.executeUpdate();
			// 判断是否存在
			if (mm > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 调用关闭数据库的操作
//			DataBase.release(rs,stat,conn);
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	/***
	 * 查询添加书本是否存在
	 * 
	 * @param name
	 * @return
	 */
	public boolean Sname(String name) {
		// TODO Auto-generated method stub
		BookDo bookdo = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from paybook where Bname=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			rs = stat.executeQuery();
			// 把rs中的每一行转换成一个Users对象
			if (rs.next()) {
				return true;
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

		return false;
	}

}
