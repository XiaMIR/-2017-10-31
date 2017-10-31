package cn.leelei.bms.entity;

import java.util.Date;
/**
 * 出版社的实体get和set
 * @author Nike
 *
 */
public class Publishers {
	 private int id;
	 private String pname;
	 private String address;
	 private Date creatrTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatrTime() {
		return creatrTime;
	}
	public void setCreatrTime(Date creatrTime) {
		this.creatrTime = creatrTime;
	}
	 
	 

}
