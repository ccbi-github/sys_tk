package com.tk.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.tk.sys.common.exception.ServiceException;
import com.tk.sys.dao.SysUserDao;
import com.tk.sys.dao.SysUserVipDao;
import com.tk.sys.dao.SysVipDao;
import com.tk.sys.entity.SysVip;
import com.tk.sys.service.SysVipService;

@Service

public class SysVipServiceImpl implements SysVipService{
	
	@Autowired
	private SysVipDao sysVipDao;
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysUserVipDao sysUserVipDao;

	@Override
	public int saveObject(SysVip entity) {
		if(entity==null){
			throw new ServiceException("参数不合法 entity="+entity);
		}
		int rows = sysVipDao.insertObject(entity);
		System.out.println("rows="+rows);
		return rows;
	}

	@Override
	public int updateObject(String username,SysVip entity) {
		if(username==null)
		throw new RuntimeException("更新vip信息的用户名不能为空");
		Integer userId = sysUserDao.findIdByUserName(username);
		Integer vipId = sysUserVipDao.findVipIdByUserId(userId);
		entity.setId(vipId);
		int rows = sysVipDao.updateObject(entity);
		System.out.println(rows);
		return rows;
	}

	@Override
	public SysVip findObjectByUsername(String username) {
		if(StringUtils.isEmpty(username))
		throw new ServiceException("查询的用户名不能为空");
		//根据用户名找到对应用户的iD
		Integer userId = sysUserDao.findIdByUserName(username);
		//根据用户id找到对应关系的vipId
		Integer vipId = sysUserVipDao.findVipIdByUserId(userId);
		//根据id查询VIP信息
		SysVip entity = sysVipDao.findObjectById(vipId);
		//返回数据
		return entity;
	}

	@Override
	public int updateObjectByUserId(Integer userId, SysVip entity) {
		if(userId==null||userId<0)
			throw new RuntimeException("用户名不合法userId= "+userId);
			 
			Integer vipId = sysUserVipDao.findVipIdByUserId(userId);
			entity.setId(vipId);
			int rows = sysVipDao.updateObject(entity);
			System.out.println(rows);
			return rows;
		 
	}


}
