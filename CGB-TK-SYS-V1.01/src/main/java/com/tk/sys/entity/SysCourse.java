package com.tk.sys.entity;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tk.common.DateJsonSerializer;
public class SysCourse implements Serializable{
	private static final long serialVersionUID = -5225339701513043662L;
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Integer type;
    private Integer state;
    private String picUrl;
    private String level;
    private Integer stuNum;
    private Date createdTime;
    private Date modifiedTime;

    
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getStuNum() {
		return stuNum;
	}
	public void setStuNum(Integer stuNum) {
		this.stuNum = stuNum;
	}
	private String createdUser;
    private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@JsonSerialize(using=DateJsonSerializer.class)
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SysCourse [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", type=" + type + ", state=" + state + ", picUrl=" + picUrl + ", level=" + level + ", stuNum="
				+ stuNum + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser="
				+ createdUser + ", modifiedUser=" + modifiedUser + "]";
	}
	 
	
    
}






