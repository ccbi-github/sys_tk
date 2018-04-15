package com.tk.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tk.common.vo.JsonResult;
import com.tk.sys.service.impl.SysBookMarksServiceImpl;

@Controller
@RequestMapping("/")
public class SysBookMarksController {
	@Autowired
	SysBookMarksServiceImpl sysBookMarksServiceImpl;
	@RequestMapping("doFindBookMarks")
	@ResponseBody
	public JsonResult doFindBookMarks(Integer user_id){
		List<Integer> list = 
		sysBookMarksServiceImpl.findBookMarks(user_id);
		return new JsonResult(list);
	}
	@RequestMapping("doInsertBookMark")
	@ResponseBody
	public JsonResult doInsertBookMark
	(Integer user_id,Integer course_id){
		
		sysBookMarksServiceImpl.insertBookMark(user_id, course_id);
		
		return new JsonResult();
	}
	@RequestMapping("doDeleteBookMark")
	@ResponseBody
	public JsonResult doDeleteBookMark(Integer id){
	
		sysBookMarksServiceImpl.deleteBookMark(id);
		return new JsonResult();
	}
	
	
}
