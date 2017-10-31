package cn.leelei.bms.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import cn.leelei.bms.dao.UserDao;
import cn.leelei.bms.entity.User;

public class UserDaoTest {

	@Test
	public void testFindall() {
		UserDao userDao = new UserDao();
		List<User> users = userDao.findall();
		if(users !=null){
		for (User user : users) {
			System.err.println(user);
			}
		}
	}

	@Test
	public void testAddUser() {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUserName("admin");
		user.setRealName("张宇");
		user.setPassWord(DigestUtils.md5Hex("111111"));
		userDao.AddUser(user);
		
	}

	@Test
	public void testDeleteUserByid() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

}
