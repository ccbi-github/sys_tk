package com.tk.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tk.common.vo.JsonResult;
import com.tk.common.vo.PageObject;
import com.tk.sys.entity.SysUser;
import com.tk.sys.entity.SysVip;
import com.tk.sys.service.SysUserCourseService;
import com.tk.sys.service.SysUserService;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserCourseService sysUserCourseService;
	
	/**
	 *陈传碧 ----整合后前端
	 */
	@RequestMapping("doUserListUI")
	public String doUserListUI() {
		return "user/user_list";
	}
	/**
	 *陈传碧 ----整合后前端
	 */
	@RequestMapping("doUserEditUI")
	public String doUserEditUI() {
		return "user/user_edit";
	}
	
	/**
	 *陈传碧 ----整合后前端
	 */
	@RequestMapping("doCommonPageUI")
	public String doCommonPageUI(){
		return "common/common_page";
	}
	
	/**
	 *陈传碧 ----整合后前端,用实体VipUser类封装
	 */
	@RequestMapping("doFindObjectPagesByVipLeve")
	@ResponseBody
	public JsonResult doFindObjectPagesByVipLeve(Integer pageCurrent,SysVip sysVip,String username) {
		System.out.println("--------pageCurrent= "+pageCurrent+
				" sysVip= "+sysVip+"----username="+username+"-----");
		PageObject<?> pageObject= sysUserService.findObjectPagesByVipLeve(pageCurrent, sysVip,username);
		return new JsonResult(pageObject);
	}
	
	/**
	 * 陈传碧 改 用户表操作
	 * 
	 */
	@RequestMapping("doSaveObjectAndVip")
	@ResponseBody
	public JsonResult doSaveObjectAndVip(SysUser entity,
			SysVip vip){
		sysUserService.saveObjectAndVip(entity, vip);
		return new JsonResult("save ok");
	}
	
	/**
	 * 陈传碧   用户表操作
	 * 
	 */
	@RequestMapping("doUpdateObjectAndVip")
	@ResponseBody
	public JsonResult doUpdateObjectAndVip
	(SysUser entity,SysVip vip,String userId){
		
		
		sysUserService.updateObjectAndVip(entity, vip,userId);
		return new JsonResult("save ok");
	}
	/**
	 * 汪鹏 负责 用户表操作
	 * 
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysUser entity,
			Integer vipId){
		sysUserService.saveObject(entity, vipId);
		return new JsonResult(1,"save ok",entity);
	}
	
	/**
	 * 汪鹏 负责 用户表操作
	 * 
	 */
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			SysUser entity, Integer vipId){
		sysUserService.updateObject(entity, vipId);
		return new JsonResult(1,"update ok",entity);
	}
	/**
	 * 汪鹏 负责 用户表操作
	 * 
	 */
	@RequestMapping("doFindObjectByUsername")
	@ResponseBody
	public JsonResult doFindObjectByUsername(String username){
		Map<String, Object> map = sysUserService.findObjectByUsername(username);
		return new JsonResult(1,"ok",map);
	}
	/**
	 *  用户表操作,陈传碧改
	 * 
	 */
	@RequestMapping("doValidByUserId")
	@ResponseBody
	public JsonResult doValidByUserId(Integer userId,
			Integer valid,String modifiedUser){
		int rows = sysUserService.validByUserId(userId, valid, modifiedUser);
		return new JsonResult("ok");
	}
	
	
	
	
	
	/**
	 * 梁朝恩负责 -数据导出操作
	 * 
	 */
	
	@RequestMapping("doExport")
	@ResponseBody
	public JsonResult doExport(){
		sysUserService.exportUsers();
		return new JsonResult("OK");
	}
	
	
	/**
	 * 梁朝恩负责 -用户课程表操作
	 * 
	 */
	@RequestMapping("doSaveUserCourse")
	@ResponseBody
	public JsonResult doSaveUserCourse(Integer user_id,
			Integer course_id,Integer validity){
		int rows = sysUserCourseService.saveObject(user_id, course_id, validity);
		return new JsonResult(1,"ok",rows);
	}
	
	
	/**
	 * 梁朝恩负责 -用户课程表操作
	 */
	@RequestMapping("doDeleteUserCourse")
	@ResponseBody
	public JsonResult doDeleteUserCourse(Integer user_id,Integer course_id){
		int rows = sysUserCourseService.deleteObject(user_id, course_id);
		return new JsonResult(1,"ok",rows);
	}
	/**
	 * 梁朝恩负责 -用户课程表操作
	 */
	@RequestMapping("doUpdateUserCourse")
	@ResponseBody
	public JsonResult doUpdateUserCourse(Integer user_id,
			Integer course_id,Integer validity){
		int rows = sysUserCourseService.updateObject(user_id, course_id, validity);
		return new JsonResult(1,"ok",rows);
	}
	/**
	 * 梁朝恩负责 -用户课程表操作
	 */
	@RequestMapping("dofindCourseValid")
	@ResponseBody
	public JsonResult dofindCourseValid(Integer user_id,Integer course_id){
		int validity = sysUserCourseService.findCourseValid(user_id, course_id);
		return new JsonResult(1,"ok",validity);
	}
}
