package cn.leelei.bms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbUtils {
	/**
	 * 得到logger对象  输出日志
	 */
	private static Logger logger = LoggerFactory.getLogger(DbUtils.class);
	
	private static BasicDataSource dataSource;
	/**
	 * 静态代码块类加载时就会调用
	 */
	static{
		InputStream is = null;
		try {
			is = DbUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			if(is!=null){
			Properties properties = new Properties();
			properties.load(is);
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
			dataSource.setUrl(properties.getProperty("jdbc.url"));
			dataSource.setUsername(properties.getProperty("jdbc.user"));
			dataSource.setPassword(properties.getProperty("jdbc.password"));
			}
			logger.debug("数据源初始化成功===================");
		} catch (IOException e) {
			e.printStackTrace();
			logger.debug("数据源初始化失败===================");
		}finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	/**
	 * 获取数据库对象链接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 关闭数据源.释放资源
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void CloseResource(Connection connection,Statement statement,ResultSet resultSet) {
		try {
			if(resultSet!=null){
				resultSet.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
