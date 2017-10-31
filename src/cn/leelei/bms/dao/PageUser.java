package cn.leelei.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.leelei.bms.entity.User;
import cn.leelei.bms.utils.DbUtils;

public class PageUser {
	/**
	* 计算总的页数
	* @return
	*/
	public int getPage(){
	int recordCount=0,t1=0,t2=0;
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	Connection connection = DbUtils.getConnection();
	
	String sql="select count(*) from users";
	try {
		statement=connection .prepareStatement(sql);
	resultSet=statement.executeQuery();
	resultSet.next();
	recordCount=resultSet.getInt(1);
	t1=recordCount%5;
	t2=recordCount/5;
	} catch (Exception e) {
	e.printStackTrace();
	}finally{
		DbUtils.CloseResource(connection, statement, resultSet);
	}
	if(t1 != 0){
	t2=t2+1;
	}
	return t2;
	}
	/**
	* 查询指定页的数据
	* @param pageNo
	* @return
	*/
	public List<User> listUser(int pageNo){
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	List<User> list=new ArrayList<User>();
	int pageSize=5;
	int page=(pageNo-1)*5;
	Connection connection = DbUtils.getConnection();
	String sql="select * from users order by id limit ?,?";
	try {
	statement=connection.prepareStatement(sql);
	statement.setInt(1, page);
	statement.setInt(2, pageSize);
	resultSet = statement.executeQuery();
	while(resultSet.next()){
	User user=new User();
	user.setId(resultSet.getInt(1));
	user.setUserName(resultSet.getString(2));
	user.setRealName(resultSet.getString(3));
	user.setPassWord(resultSet.getString(4));
	list.add(user);
	}
	} catch (Exception e) {
	e.printStackTrace();
	}finally{
		DbUtils.CloseResource(connection, statement, resultSet);
	}
	return list;
	}
}


