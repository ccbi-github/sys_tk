package com.tk.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysBookMarks implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5158412333628183843L;
	private Integer id;
	private Integer user_id;
	private Integer course_id;
	private Date createdTime ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "SysBookMarks [id=" + id + ", user_id=" + user_id + ", course_id=" + course_id + ", createdTime="
				+ createdTime + "]";
	} 

	
}
