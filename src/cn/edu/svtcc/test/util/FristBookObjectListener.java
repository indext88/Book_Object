package cn.edu.svtcc.test.util;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import cn.edu.svtcc.test.dao.DataSourceProvider;

/**
 * Application Lifecycle Listener implementation class FristBookObjectListener
 *
 */
@WebListener
public class FristBookObjectListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public FristBookObjectListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		DataSource ds = DataSourceProvider.getinstance().getDataSource();
		try {
			ds.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		// 通过JNDI获得tomcat中配置的DataSource
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbpooling");
			DataSourceProvider.getinstance().setDataSource(ds);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
