package cn.edu.svtcc.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import cn.edu.svtcc.test.pojo.OrderDao;
import cn.edu.svtcc.test.shoppingcar.shoppingItem;

public class Orderimpl {
	String FIND_ID = "select last_insert_id()";
	String TRANSACTION = "start transaction";
	String ROLLBACK = "rollback";
	String COMMIT = "commit";
	DataSource ds;

	public Orderimpl() {
		ds = DataSourceProvider.getinstance().getDataSource();
	}

//	private DataBase ds;

	/*
	 * @return -203开启事务失败 -201创建订单出错 -202插入单类商品出错
	 */
	public int insertOrder(int userId, List<shoppingItem> list) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		int keyId = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		// 时间
		String date = df.format(new java.util.Date());
		// 总价
		double sum = 0.0;
		for (int i = 0; i < list.size(); i++) {
			shoppingItem shoppingItem = list.get(i);
			sum = sum + shoppingItem.getItem().getUntiPrice() * shoppingItem.getAmout();
		}

		try {
			conn = ds.getConnection();
			if (conn.getAutoCommit()) {
				conn.setAutoCommit(false);
			} else {
				System.out.println("开启事务失败");
				return -203;
			}
			String sql = "insert into orders(OrderDate,UserId,TotalPrice) values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, date);
			stmt.setInt(2, userId);
			stmt.setDouble(3, sum);
			if (stmt.executeUpdate() == -1) {
				System.out.println("创建订单出错");
				return -201;
			}

			stmt = conn.prepareStatement(FIND_ID);
			rs = stmt.executeQuery();
			if (rs.next()) {
				keyId = rs.getInt(1);
			}

			for (int i = 0; i < list.size(); i++) {
				shoppingItem item = list.get(i);
				String sql2 = "insert into orderbook(OrderID,BookID,Quantity,UnitPrice) values(?,?,?,?)";
				stmt = conn.prepareStatement(sql2);
				stmt.setInt(1, keyId);
				stmt.setInt(2, list.get(i).getItem().getId());
				stmt.setInt(3, list.get(i).getAmout());
				stmt.setDouble(4, list.get(i).getItem().getUntiPrice());
				if (stmt.executeUpdate() == -1) {
					System.out.println("插入单类商品出错");
					return -202;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return keyId;
	}

	/**
	 * 根据订单id获取订单信息
	 * 
	 * @param keyId
	 * @return
	 */
	public OrderDao getOrder(int keyId) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT *	from orders where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, keyId);
			rs = stmt.executeQuery();
			OrderDao or = new OrderDao();
			if (rs.next()) {
				or.setId(rs.getInt(1));
				or.setOrderDate(rs.getDate(2).toString());
				or.setUserId(rs.getInt(3));
				or.setTotalPrice(rs.getDouble(4));
			}
			return or;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据用户id查找用户所有订单
	 * 
	 * @param userId
	 * @return
	 */
	public List<OrderDao> listUserOrder(int userId) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		List<OrderDao> list = new ArrayList<OrderDao>();

		try {
			conn = ds.getConnection();
			String sql = "select * from orders where userid = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				OrderDao or = new OrderDao();
				or.setId(rs.getInt(1));
				or.setOrderDate(rs.getDate(2).toString());
				or.setUserId(rs.getInt(3));
				or.setTotalPrice(rs.getDouble(4));
				list.add(or);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/***
	 * 根据商品ID删除商品
	 * 
	 * @param keyId
	 * @return
	 */
	public boolean del_order(String userId) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			String sql = "delete from orders where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			int mm = stmt.executeUpdate();
			while (mm > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
