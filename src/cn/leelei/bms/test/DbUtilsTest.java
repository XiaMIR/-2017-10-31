package cn.leelei.bms.test;

import java.sql.Connection;

import org.junit.Test;

import cn.leelei.bms.utils.DbUtils;

public class DbUtilsTest {

	@Test
	public void testGetConnection() {
		Connection connection = DbUtils.getConnection();
		System.err.println(connection);
	}


}
