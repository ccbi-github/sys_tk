package com.tk.sys.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tk.common.vo.JsonResult;
import com.tk.common.vo.PageObject;
import com.tk.sys.entity.SysCourse;
import com.tk.sys.service.SysCourseService;
@Controller
@RequestMapping("/course/")
public class SysCourseController {
	@Autowired
	private SysCourseService sysCourseService;
	
	@RequestMapping("courseUI")
	public String courseUI() {
		
		return "lesson/lesson_list";
	}
	@RequestMapping("doCommonPageUI")
	public String doCommonPageUI(){
		return "common/common_page";
	}
	
	
	@RequestMapping("editUI")
	public String editUI(){
		return "lesson/lesson_edit";
	}
	
	
	//梁朝嗯
	@RequestMapping("export")
	@ResponseBody
	public JsonResult export(){
		sysCourseService.exportCourses();
		return new JsonResult("OK");
	}
	/**ccb**/
	@RequestMapping("doFindObjectPagesByType")
	@ResponseBody
	public JsonResult doFindObjectPagesByType(Integer pageCurrent,Integer type,String name){
		PageObject coursePage = sysCourseService.findObjectPagesByType(pageCurrent,type,name);
		return new JsonResult("ok", coursePage);
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		SysCourse entity = sysCourseService.findObjectById(id);
		return new JsonResult("ok", entity);
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysCourse entity){
		sysCourseService.insertObject(entity);
		return new JsonResult("save ok");
	}
	//**ccb**
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysCourse entity){
		System.out.println("entity.id="+entity.getId());
		entity.setModifiedUser("admin");
		sysCourseService.updateObjectById(entity);
		return new JsonResult("update OK");
	}
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(String ids){
		sysCourseService.deleteObjects(ids);
		return new JsonResult("update OK");
	}
	
	@RequestMapping("doChangeStateByIds")
	@ResponseBody
	public JsonResult doChangeStateByIds(String ids, Integer state, String modifiedUser){
		/**
		 * state,表示course的状态，1表示上架，0表示下架
		 */
		
		 System.out.println("控制层 ids= "+ ids+" state= "+state);
		sysCourseService.changeStateByIds(ids, state, "admin"); 
		return new JsonResult("change state ok");
	}
	
	
	
	@RequestMapping("doChangeStateById")
	@ResponseBody
	public JsonResult doChangeStateById(Integer id, Integer state, String modifiedUser){
		/**
		 * state,表示course的状态，1表示上架，0表示下架
		 */
		sysCourseService.changeStateById(id, state, "admin");
		return new JsonResult("change state ok");
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name, Integer pageNum){
		PageInfo info = sysCourseService.findPageObjects(name, pageNum);
		return new JsonResult("find objects ok",info);
	}
}	
