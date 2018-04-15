package com.tk.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SalesRecord implements Serializable{
	private static final long serialVersionUID = 165074371673422511L;
	private Integer id;
	private String orderNumber;
	private Integer cource_id;
	private Integer user_id;
	private Double price;
	private Date buyingTime;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	private int state=1;

	public SalesRecord() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getCource_id() {
		return cource_id;
	}
	public void setCource_id(Integer cource_id) {
		this.cource_id = cource_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getBuyingTime() {
		return buyingTime;
	}
	public void setBuyingTime(Date buyingTime) {
		this.buyingTime = buyingTime;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "SalesRecord [id=" + id + ", orderNumber=" + orderNumber + ", cource_id=" + cource_id + ", user_id="
				+ user_id + ", price=" + price + ", buyingTime=" + buyingTime + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser
				+ ", state=" + state + "]";
	}

	
	
}
