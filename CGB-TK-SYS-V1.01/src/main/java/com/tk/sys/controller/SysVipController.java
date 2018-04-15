package com.tk.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tk.common.vo.JsonResult;
import com.tk.sys.entity.SysVip;
import com.tk.sys.service.SysVipService;

@RequestMapping("/vip/")
@Controller
public class SysVipController {
	
	@Autowired
	private SysVipService sysVipService;
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysVip entity){
		
		sysVipService.saveObject(entity);
		return new JsonResult(1,"save ok",entity);
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(String username,SysVip entity){
		sysVipService.updateObject(username,entity);
		return new JsonResult(1,"update ok");
	}
	
	/**陈传碧**/
	@RequestMapping("doUpdateObjectByUserId")
	@ResponseBody
	public JsonResult doUpdateObjectByUserId(Integer userId,SysVip entity){
		sysVipService.updateObjectByUserId(userId, entity);
		return new JsonResult(1,"update ok");
	}
	
	@RequestMapping("doFindObjectByUsername")
	@ResponseBody
	public JsonResult doFindObjectByUsername(String username){
		SysVip entity = sysVipService.findObjectByUsername(username);
		return new JsonResult(1,"ok",entity);
	}

}
