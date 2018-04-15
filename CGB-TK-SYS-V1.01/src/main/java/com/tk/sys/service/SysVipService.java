package com.tk.sys.service;

import com.tk.sys.entity.SysVip;

public interface SysVipService {

	/**保存vip信息*/
	int saveObject(SysVip entity);
	
	/**修改vip信息*/
	int updateObject(String username,SysVip entity);
	
	/**陈传碧--修改vip信息*/
	int updateObjectByUserId(Integer userId,SysVip entity);
	/**根据用户名查找对应的vip信息*/
	SysVip findObjectByUsername(String username);
}
