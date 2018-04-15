package com.tk.common.vo;

import java.io.Serializable;

import com.tk.sys.entity.SysUser;

public class VipUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer vipLevel;
	private Integer validity;
	private SysUser sysUser;
	
	public Integer getVipLevel() {
		return vipLevel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}
	public Integer getValidity() {
		return validity;
	}
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	@Override
	public String toString() {
		return "VipUser [id=" + id + ", vipLevel=" + vipLevel + ", validity=" + validity + ", sysUser=" + sysUser + "]";
	}
	
	
}
