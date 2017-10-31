package cn.leelei.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.leelei.bms.entity.User;
import cn.leelei.bms.utils.DbUtils;

public class UserDao {
	//每页显示的数据条数
	int userNum = 4;
	/**
	 * 获取用户个数
	 * 
	 * @return
	 */
	public int findUserTotalNum() {
		// 得到数据库链接
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			// 判断connection为不为空，如不为空继续
			if (connection != null) {
				String sql = "SELECT count(*) FROM users";
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				int num=0;
				if(resultSet.next()){
					 num= resultSet.getInt(1);  
				}
				
				return num;
			}
			//
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.CloseResource(connection, statement, resultSet);
		}

		return 0;
	}

	/**
	 * 根据页数获取用户数据
	 * 
	 * @param currentPage
	 * @return
	 */

	public List<User> findUserListByCurrentPage(int currentPage) {
		// 每页显示的数据条数
		
		int beginIndex = (currentPage - 1) * userNum + 1;

		// 判断余下是否足够一页
		// 获取数据条数
		int userTotalNum = findUserTotalNum();
		// 默认页数足够
		boolean isCan = true;
		int tempEndNum = 0;
		if (currentPage * userNum > userTotalNum) {
			isCan = false;
			tempEndNum = userTotalNum - beginIndex;
		}

		// 得到数据库链接
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			List<User> users = new ArrayList<User>();
			User temp = null;
			// 判断connection为不为空，如不为空继续
			if (connection != null) {
				StringBuffer sqlBuf = new StringBuffer("SELECT * FROM users ORDER BY ID LIMIT ");
				sqlBuf.append(beginIndex);
				sqlBuf.append(" , ");

				if (isCan) {// 数据足够
					sqlBuf.append(userNum);
				} else {// 数据不够
					sqlBuf.append(tempEndNum);
				}

				String sql = sqlBuf.toString();

				// String sql = "SELECT * FROM users ORDER BY ID LIMIT ";
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					temp = new User();
					temp.setId(resultSet.getInt("id"));
					temp.setUserName(resultSet.getString("userName"));
					temp.setRealName(resultSet.getString("realName"));
					temp.setPassWord(resultSet.getString("passWord"));
					users.add(temp);
					temp = null;
				}

			}
			System.out.println(users.size()+"个数");
			//
			return users.isEmpty() ? null : users;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.CloseResource(connection, statement, resultSet);
		}
		return null;
	}

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public List<User> findall() {
		// 得到数据库链接
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			List<User> users = new ArrayList<User>();
			User temp = null;
			// 判断connection为不为空，如不为空继续
			if (connection != null) {
				String sql = "SELECT * FROM users";
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					temp = new User();
					temp.setId(resultSet.getInt("id"));
					temp.setUserName(resultSet.getString("userName"));
					temp.setRealName(resultSet.getString("realName"));
					temp.setPassWord(resultSet.getString("passWord"));
					users.add(temp);
					temp = null;
				}

			}
			//
			return users.isEmpty() ? null : users;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.CloseResource(connection, statement, resultSet);
		}

		return null;

	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void AddUser(User user) {
		// 得到数据库链接
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		try {
			// 判断connection为不为空，如不为空继续
			if (connection != null) {
				String sql = "INSERT INTO users (userName,realName,passWord)VALUES(?,?,?)";
				statement = connection.prepareStatement(sql);
				// 绑定数据
				statement.setString(1, user.getUserName());
				statement.setString(2, user.getRealName());
				statement.setString(3, user.getPassWord());
				// 执行语句
				statement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.CloseResource(connection, statement, null);
		}
	}

	/**
	 * 删除用户 根据id删除
	 * 
	 * @param user
	 */
	public void deleteUserByid(User user) {
		// 得到数据库链接
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		try {
			// 判断connection为不为空，如不为空继续
			if (connection != null) {
				String sql = "DELETE  FROM users WHERE id=?";
				statement = connection.prepareStatement(sql);
				// 绑定数据
				statement.setInt(1, user.getId());
				// 执行语句
				statement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.CloseResource(connection, statement, null);
		}
	}

	public void updateUser(User user) {
		// 得到数据库链接
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		try {
			// 判断connection为不为空，如不为空继续
			if (connection != null) {
				String sql = "UPDATE users SET  realName=?,passWord=? WHERE id=?";
				statement = connection.prepareStatement(sql);
				// 绑定数据
				statement.setString(1, user.getRealName());
				statement.setString(2, user.getPassWord());
				statement.setInt(3, user.getId());
				// 执行语句
				statement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.CloseResource(connection, statement, null);
		}
	}

	/**
	 * 用户登录验证 需要校验的用户信息 返回数据库中存在的真实姓名
	 * 
	 * @param user
	 */
	public User ValidateUser(User user) {

		// 得到数据库链接
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			User temp = null;
			// 判断connection为不为空，如不为空继续
			if (connection != null) {
				String sql = "SELECT * FROM users WHERE userName=? AND passWord=?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, user.getUserName());
				statement.setString(2, user.getPassWord());
				resultSet = statement.executeQuery();
				if (resultSet.first()) {
					temp = new User();
					temp.setId(resultSet.getInt("id"));
					temp.setUserName(resultSet.getString("userName"));
					temp.setRealName(resultSet.getString("realName"));
					temp.setPassWord(resultSet.getString("passWord"));
				}

			}
			return temp;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.CloseResource(connection, statement, resultSet);
		}
		return user;

	}

	/**
	 * 通过id得到用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User findUserinfoById(int id) {
		// 得到数据库链接
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			User temp = null;
			// 判断connection为不为空，如不为空继续
			if (connection != null) {
				String sql = "SELECT * FROM users WHERE id=?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				resultSet = statement.executeQuery();
				if (resultSet.first()) {
					temp = new User();
					temp.setId(resultSet.getInt("id"));
					temp.setUserName(resultSet.getString("userName"));
					temp.setRealName(resultSet.getString("realName"));
					temp.setPassWord(resultSet.getString("passWord"));
				}
			}
			return temp;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.CloseResource(connection, statement, resultSet);
		}
		return null;

	}

}
