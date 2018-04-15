package com.tk.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tk.common.vo.VipUser;
import com.tk.sys.entity.SysVip;

public interface SysVipDao {
	
	
	
	/**ccb*/
	List<VipUser>findObjectsPage
			(@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize,
			@Param("sysVip") SysVip sysVip,
			@Param("username") String username);
	
	
	
	int findRowCount
	(@Param("sysVip")SysVip sysVip,@Param("username")String username);
	
	/**执行insert操作*/
	int insertObject(SysVip entity);
	
	/**通过vip的id来修改vip**/
	int updateObject(SysVip entity);

	SysVip findObjectById(
			@Param("id")Integer vipId);
	
	
}
