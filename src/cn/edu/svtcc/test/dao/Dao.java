package cn.edu.svtcc.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import cn.edu.svtcc.test.pojo.Users;

public class Dao {
	DataSource ds;

	public Dao() {
		// 通过JSDI来得到Tomcat中配置的数据源

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

//	private DataBase ds;

	/**
	 * 登录验证方法
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean tel(String name, String password) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from users where LoginId=? and LoginPwd=?";
			stat = conn.prepareStatement(sql);
			// 设置？的值
			stat.setString(1, name);
			stat.setString(2, password);
			rs = stat.executeQuery();
			// 判断是否存在
			if (rs.next()) {
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

	/**
	 * 注册验证方法
	 * 
	 * @param name
	 * @param password
	 * @param username
	 * @param phone
	 * @param mail
	 * @param address
	 * @return
	 */

	public boolean addusers(String name, String password, String username, String phone, String mail, String address) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
//			conn=DataBase.getConnectiob();
			conn = ds.getConnection();
			String sql = "insert into users(LoginId,LoginPwd,Name,Phone,Mail,Address,UserRoleId,UserStateId)"
					+ "values(?,?,?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			stat.setString(2, password);
			stat.setString(3, username);
			stat.setString(4, phone);
			stat.setString(5, mail);
			stat.setString(6, address);
			stat.setString(7, "1");
			stat.setString(8, "1");
			// 设置？的值
			int num = stat.executeUpdate();
			// 判断是否存在
			if (num > 0) {
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

	/**
	 * 注册用户是否存在验证方法
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean zuce_b(String name) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from users where LoginId=?";
			stat = conn.prepareStatement(sql);
			// 设置？的值
			stat.setString(1, name);
			rs = stat.executeQuery();
			// 判断是否存在
			if (rs.next()) {
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

	public int getuserId(String name) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "select Id from users where LoginId=?";
			stat = conn.prepareStatement(sql);
			// 设置？的值
			stat.setString(1, name);
			rs = stat.executeQuery();
			// 判断是否存在
			if (rs.next()) {
				return rs.getInt(1);
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
		return 5;

	}

	public List<Users> getAllUsers() {
		List<Users> userlist = new ArrayList<Users>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		Users user = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from users";
			stat = conn.prepareStatement(sql);

			rs = stat.executeQuery();
			// 把rs中的每一行转换成一个Users对象
			while (rs.next()) {
				user = new Users();
				// 得到users表中的每一列的名字
				user.setLoginId(rs.getString(2));
				user.setLoginPwd(rs.getString(3));
				user.setName(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setMail(rs.getString(7));
				// 把user对象加到集合里
				userlist.add(user);
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

		return userlist;
	}

	// 测试getAllUsers
	public static void main(String[] args) {
		Dao dao = new Dao();
		List<Users> user = dao.getAllUsers();// 得到getAllUsers()中的集合变为类型如数组赋给user
		System.out.println("size:" + user.size());
	}

}
