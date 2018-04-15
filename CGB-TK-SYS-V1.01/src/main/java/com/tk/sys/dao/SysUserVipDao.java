package com.tk.sys.dao;

import org.apache.ibatis.annotations.Param;

/**通过这个接口操作用户与角色之间的关系数据*/
public interface SysUserVipDao {
	
	
	/**向表中写入关系数据*/
	int insertObject(
			@Param("userId")Integer userId,
			@Param("vipId")Integer vipId);

	/**根据用户id查询vipId*/
	Integer findVipIdByUserId(Integer userId);
	
	/**ccb 根据vipd的id查询userId*/
	Integer findUserIdByVipId(Integer vipId);
	
	
	/**根据用户id删除中间表角色信息相关记录*/
	 int deleteObject(Integer userId);
	
}
