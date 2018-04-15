package com.tk.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tk.sys.entity.SysUser;

/**此接口的实现类会交给Spring创建*/
public interface SysUserDao {
	/**
	 * ccb
	 * 查找总数
	 * @return
	 */
	int findRowCount();
	/**ccb,**/
	 List<SysUser>findAllObjectPageAndVip
	 (@Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize, @Param("sysUser") SysUser sysUser);
	
	 /**ccb,**/
	 SysUser findObjectById(Integer id);
	 
	 
	/**写入用户信息*/
	int insertObject(SysUser entity);
	
	/**所有用户信息*/
	 List<SysUser> findAllObject();
	 
	/**更新用户信息*/
	int updateObject(SysUser entity);
	
	/**根据用户名查找用户信息*/
	SysUser findObjectByUserName(String username);
	
	/**根据用户名查找用户ID*/
	Integer findIdByUserName(String username);
	
	/**通过这个方法实现禁用启用操作*/
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);
	
}
