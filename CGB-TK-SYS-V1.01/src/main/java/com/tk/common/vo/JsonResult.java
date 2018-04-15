package com.tk.common.vo;
import java.io.Serializable;
public class JsonResult implements Serializable{
	private static final long serialVersionUID = 1L;
	private String message = "ok";
	private Integer state = 1;
	private Object data = null;
	
	public JsonResult() {}
	

	 public JsonResult(int state,String message) {
  		 this.state=state;
  		 this.message=message;
  	 }
  	 public JsonResult(int state,String message,Object data) {
  		 this.state=state;
  		 this.message=message;
  		 this.data=data;
  	 }
  	 /**当在控制层将一个JsonResult对象
  	  * 转换为JSON串时,会调用此对象对应的
  	  * get方法*/
	
	
	
	
	public JsonResult(Throwable e) {
		this.message = e.getMessage();
		this.state = 0;
	}
	public JsonResult(String message, Object data) {
		this.message = message;
		this.data = data;
	}
	public JsonResult(String message) {
		this.message = message;
	}
	public JsonResult(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "JsonResult [message=" + message + ", state=" + state + ", data=" + data + "]";
	}
}
