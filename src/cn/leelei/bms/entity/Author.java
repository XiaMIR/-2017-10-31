package cn.leelei.bms.entity;

import java.util.Date;

/**
 * 作者实体表的get和set方法
 * @author Nike
 *
 */
public class Author {
	 private int id;
	 private String aname;
	 private Date birthday;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
