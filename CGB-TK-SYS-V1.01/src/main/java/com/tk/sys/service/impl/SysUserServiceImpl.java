package com.tk.sys.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.crypto.hash.SimpleHashRequest;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.tk.common.utils.ExportExcel;
import com.tk.common.vo.PageObject;
import com.tk.common.vo.VipUser;
import com.tk.sys.common.exception.ServiceException;
import com.tk.sys.dao.SysUserDao;
import com.tk.sys.dao.SysUserVipDao;
import com.tk.sys.dao.SysVipDao;
import com.tk.sys.entity.SysUser;
import com.tk.sys.entity.SysVip;
import com.tk.sys.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysUserVipDao sysUserVipDao;
	
	@Autowired
	private SysVipDao sysVipDao;
	
	private Logger logger=Logger.getLogger(SysUserServiceImpl.class);
	
	
	@Override
	public int saveObject(SysUser entity, Integer vipId) {
		// 1.保存用户信息
		String pwd = entity.getPassword();
		String username = entity.getUsername();
		if (StringUtils.isEmpty(username))
			throw new ServiceException("用户名不能为空");
		if (StringUtils.isEmpty(pwd))
			throw new ServiceException("密码不能为空");
		// 2.给密码增加盐值加密
		String saltStr = UUID.randomUUID().toString();
		ByteSource salt = ByteSource.Util.bytes(saltStr);
		String newPwd = new SimpleHash("MD5", entity.getPassword(), salt).toString();
		entity.setPassword(newPwd);
		entity.setSalt(saltStr);
		// 3.存入数据库
		int rows = sysUserDao.insertObject(entity);

		// 4.保存关系数据
		sysUserVipDao.insertObject(entity.getId(), vipId);
		return rows;
	}

	@Override
	public int updateObject(SysUser entity, Integer vipId) {

		// 1.参数验证
		if (entity == null)
			throw new ServiceException("更新对象不能为空");
		if (entity.getUsername() == null)
			throw new ServiceException("更新用户时用户名不能为空");
		// 根据传入的用户名找到对应的用户ID
		Integer userId = sysUserDao.findIdByUserName(entity.getUsername());
		// 初始化传入用户对象的ID
		entity.setId(userId);
		// 2.更新数据
		if (!StringUtils.isEmpty(entity.getPassword())) {
			String saltStr = UUID.randomUUID().toString();
			ByteSource salt = ByteSource.Util.bytes(saltStr);
			String pwd = new SimpleHash("MD5", entity.getPassword(), salt).toString();
			entity.setPassword(pwd);
			entity.setSalt(saltStr);
		}
		// 修改用户信息
		int rows = sysUserDao.updateObject(entity);
		// 3.获取当前用户对应的vipId
		vipId = sysUserVipDao.findVipIdByUserId(userId);
		System.out.println(vipId);
		// 4.删除关系数据
		sysUserVipDao.deleteObject(userId);
		// 5.重新建立关系
		sysUserVipDao.insertObject(userId, vipId);
		return rows;
	}

	@Override
	public Map<String, Object> findObjectByUsername(String username) {
		if (StringUtils.isEmpty(username))
			throw new ServiceException("请输入需要查询的用户名");
		SysUser entity = sysUserDao.findObjectByUserName(username);
		Integer userId = sysUserDao.findIdByUserName(username);
		Integer vipId = sysUserVipDao.findVipIdByUserId(userId);
		Map<String, Object> map = new HashMap<>();
		map.put("sysUser", entity);
		map.put("vipId", vipId);
		return map;
	}

	@Override
	public int validByUserId(Integer userId, Integer valid, String modifiedUser) {
		// 1.参数验证
		if (userId==null||userId<0)
			throw new ServiceException("请选择需要更新的用户,userId="+userId);
		if (valid == null || valid < 0)
			throw new ServiceException("状态值无效");
		
		// 2.修改状态信息
		int rows = sysUserDao.validById(userId, valid, modifiedUser);
		return rows;
	}

	@Override
	public void exportUsers() {
		String path = "com.tk.sys.entity.SysUser";
		List<SysUser> list = sysUserDao.findAllObject();
		System.out.println(list);
		ExportExcel ee = new ExportExcel(list, path);
		ee.toExcel();
	}

	@Override
	public int saveObjectAndVip(SysUser entity, SysVip vip) {
		// 1.保存用户信息
		String pwd = entity.getPassword();
		String username = entity.getUsername();

		//验证entity的参数的合法性
		 verifyParameter(entity);
		// 2.给密码增加盐值加密
		String saltStr = UUID.randomUUID().toString().replace("-", "");

		ByteSource salt = ByteSource.Util.bytes(saltStr);
		String newPwd = new SimpleHash("MD5", entity.getPassword(), salt).toString();
		entity.setPassword(newPwd);
		entity.setSalt(saltStr);
		entity.setValid(1);//默认启用状态
		System.out.println("entity= "+entity);
		// 3.存入数据库
		int rows = sysUserDao.insertObject(entity);
		sysVipDao.insertObject(vip);

		// 4.保存关系数据
		  sysUserVipDao.insertObject(entity.getId(), vip.getId());
		return rows;

	}


	@Override
	public PageObject<VipUser> findObjectPagesByVipLeve
	(Integer pageCurrent, SysVip sysVip,String username) {
		if(!StringUtils.isEmpty(username)){
			try {
				byte []bytes=username.getBytes("iso-8859-1");
				username=new String(bytes, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
		if(pageCurrent==null ||pageCurrent<1){
			throw new ServiceException("参数不合法 pageCurrent= "+pageCurrent);
		}
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<VipUser> vipUserList=sysVipDao.findObjectsPage(startIndex, pageSize, sysVip,username);
		int rowCount=sysVipDao.findRowCount(sysVip,username);//

			PageObject<VipUser> pageObject = new PageObject<>();
			pageObject.setPageSize(pageSize);
			pageObject.setRowCount(rowCount);
			pageObject.setRecords(vipUserList);
			pageObject.setPageCurrent(pageCurrent);
			return pageObject;

	}

	/**ccb*/
	@Override
	public int updateObjectAndVip(SysUser entity, SysVip vip,String userId) {
		 //修改了这里2018-4-6
		 
		 if(StringUtils.isEmpty(userId)){
			 throw new ServiceException("用户id不能为空");
		 }
		 entity.setId(Integer.parseInt(userId));
		 if(!StringUtils.isEmpty(entity.getPassword())){
			 String newPassword=entity.getPassword();
			 String username=entity.getUsername();
			 String salt=UUID.randomUUID().toString().replace("-", "");
			 ByteSource saltByteSource=ByteSource.Util.bytes(salt);
			 String password= new SimpleHash("MD5", newPassword, saltByteSource).toString();
			 entity.setPassword(password);
			 entity.setSalt(salt);
		 }
		Integer vipId=sysUserVipDao.findVipIdByUserId(entity.getId());
		vip.setId(vipId);
		int rows=0;
		try {
			 rows =sysUserDao.updateObject(entity);
			/**通过vip的id来修改vip**/
			sysVipDao.updateObject(vip);
			logger.info("用户信息修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("用户信息修改失败:"+e.getMessage());
		}
		return rows;
	}

	private void verifyParameter(SysUser entity) {
		 if(StringUtils.isEmpty(entity.getUsername())){
			 throw new ServiceException("用户名不能为空");
		 }
		 if(StringUtils.isEmpty(entity.getPassword())){
			 throw new ServiceException("密码不能为空");
		 }
		 
		 if(StringUtils.isEmpty(entity.getPhone())){
			 throw new ServiceException("电话号码不能为空");
		 }
		 
		 if(StringUtils.isEmpty(entity.getEmail())){
			 throw new ServiceException("邮件不能为空");
		 }
		
	}

	 

}
