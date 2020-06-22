package cn.edu.svtcc.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import cn.edu.svtcc.test.interfacee.CategoriesDao;
import cn.edu.svtcc.test.pojo.CategoriesDo;

public class CategoriesDaoimpl implements CategoriesDao {
//	private DataBase ds;
	DataSource ds;

	public CategoriesDaoimpl() {
		// 直接调用FristBookObjectListener中的DataSourceProvider的方法
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
	public List<CategoriesDo> listCategories() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		// 创建一个list<categoriesDao>的对象categories
		List<CategoriesDo> categorieslist = new ArrayList<CategoriesDo>();
		try {
			// 调用DateBase.getConnection()得到一个Connection的对象connection
			conn = ds.getConnection();
			// 声明一个String的对象Sql,保存要执行的sql语句
			String sql = "SELECT * FROM categories";
			// 创建一个PreparedStatement的对象stmt
			stat = conn.prepareStatement(sql);
			// 调用stmt.execuQuery()执行查询，返回结果给Resultset的对象
			rs = stat.executeQuery();
			// 循环遍历rs,将rs中的每一行转换成CategoriesDo的对象
			while (rs.next()) {

				CategoriesDo catedo = new CategoriesDo();
				// 得到结果集中的每一个元素
				catedo.setId(rs.getInt(1));
				catedo.setName(rs.getString(2));
				// 将得到的集合添加到categorieslist中
				categorieslist.add(catedo);
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

		return categorieslist;
	}

	// 测试类
	public static void main(String[] args) {
		CategoriesDaoimpl dao = new CategoriesDaoimpl();
		List<CategoriesDo> list = dao.listCategories();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.size());
	}

}
