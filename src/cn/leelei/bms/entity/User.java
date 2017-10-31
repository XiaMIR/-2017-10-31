package cn.leelei.bms.entity;

import java.io.Serializable;

/**
 * 管理员User表sget和set
 * @author Nike
 *
 */
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String userName;
    private String realName;
	private String passWord;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", realName=" + realName + ", passWord=" + passWord + "]";
	}
	

	
}