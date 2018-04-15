package com.tk.sys.service;

import java.util.Map;

import com.tk.common.vo.PageObject;
import com.tk.sys.entity.SysUser;
import com.tk.sys.entity.SysVip;

public interface SysUserService {
	
	
	/**保存用户信息*/
	int saveObject(SysUser entity,Integer vipId);
	
	/**保存用户信息*/
	int saveObjectAndVip(SysUser entity,SysVip vip);
	
	/**更新用户信息*/
	int updateObject(SysUser entity,Integer vipId);
	
	/**根据用户ID查询用户信息及用户相关的vip信息*/
	Map<String,Object> findObjectByUsername(String username);
	

	
	/**ccb*/
	PageObject findObjectPagesByVipLeve(Integer pageCurrent,SysVip sysVip,String username);
	
	
	
	/**禁用和启用*/
	int validByUserId(Integer userId,
			Integer valid,String modifiedUser);
	
	/**export Users info*/
	void exportUsers();
	
	/**ccb*/
	int updateObjectAndVip(SysUser entity, SysVip vip,String userId);
	
	/**查询找所有用户**/
	//Map<String,Object>findAllObject();
}
