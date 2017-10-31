package cn.leelei.bms.entity;

import java.util.Date;
/**
 * 图书实体表get和set
 * @author Nike
 *
 */
public class Books {
	  private String isbn;
	  private String bname;
	  private Float price;
	  private Date publishtime;
	  private String versiono;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	public String getVersiono() {
		return versiono;
	}
	public void setVersiono(String versiono) {
		this.versiono = versiono;
	}
	  

}
