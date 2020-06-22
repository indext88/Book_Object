package cn.edu.svtcc.test.dao;
/**
 * DataSourceProvider的提供器类
 * 采用单例模式
 * @author indext
 *
 */

import javax.sql.DataSource;

public class DataSourceProvider {
	private DataSource dataSource;
	
	private static DataSourceProvider instance;
	/**
	 * 私有构造方法
	 * synchronized (instance)同步膜
	 */
	private DataSourceProvider() {}
	
	public static DataSourceProvider getinstance() {
//		synchronized (instance) {
//			if(instance==null) {
//				instance=new DataSourceProvider();
//			}
		
		if(instance==null) {
		instance=new DataSourceProvider();
		}
		return instance;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
