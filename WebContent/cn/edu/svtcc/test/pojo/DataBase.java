package cn.edu.svtcc.test.pojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class DataBase {
	
	static String drivername,url,username,password;
	static {
		Properties p;
		p=new Properties();
		try {
			p.load(DataBase.class.getResourceAsStream("into.properties"));
			drivername=p.getProperty("drivername");
			url=p.getProperty("url");
			username=p.getProperty("username");
			password=p.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static Connection getConnectiob() throws SQLException{
		try {
			//ע�����ݿ�����
			Class.forName(drivername);
			//ͨ��DriverManager��ȡ���ݿ�����
			Connection conn=DriverManager.getConnection(url,username,password);
			return conn;
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}return null;
	}
	public static void release(Statement stat,Connection conn){
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stat=null;
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=null;
		}
	}
	public static void release(ResultSet rs,Statement stat,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
		release(stat, conn);
		
	}
}
