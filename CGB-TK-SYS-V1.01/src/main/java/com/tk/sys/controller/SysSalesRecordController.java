package com.tk.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tk.common.vo.JsonResult;
import com.tk.common.vo.PageObject;
import com.tk.sys.entity.SalesRecord;
import com.tk.sys.service.SalesRecordService;

@Controller
@RequestMapping("/sales/")
public class SysSalesRecordController {
	@Autowired
	private SalesRecordService salesRecordService;
	@RequestMapping("indexUI")
	public String indexUI(){
		return "index";
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SalesRecord sales){
		salesRecordService.updateObject(sales);
		return new JsonResult("update ok");
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			String orderNumber,Integer pageCurrent){
		PageObject<SalesRecord> pageObject = 
				salesRecordService.findPageObjects(orderNumber, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SalesRecord sales){
		salesRecordService.insertObject(sales);
		return new JsonResult("save ok");
	}
	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(){
		return new JsonResult(salesRecordService.findObject());
	}
	
}
