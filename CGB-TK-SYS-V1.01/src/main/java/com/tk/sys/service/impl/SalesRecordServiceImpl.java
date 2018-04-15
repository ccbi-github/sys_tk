package com.tk.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.tk.common.vo.PageObject;
import com.tk.sys.common.exception.ServiceException;
import com.tk.sys.dao.SalesRecordDao;
import com.tk.sys.entity.SalesRecord;
import com.tk.sys.service.SalesRecordService;

@Service
public class SalesRecordServiceImpl implements SalesRecordService {
	@Autowired
	private SalesRecordDao salesRecordDao;
	@Override
	public int updateObject(SalesRecord sales) {
		if(sales==null)
			throw new ServiceException("订单信息不能为空");
		if(StringUtils.isEmpty(sales.getOrderNumber()))
			throw new ServiceException("请正确选择订单号");
		int rows;
		try {
			System.out.println(sales);
			rows = salesRecordDao.updateObject(sales);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统异常，稍后重试");
		}
		return rows;
	}
	@Override
	public List<SalesRecord> findObject() {
		return salesRecordDao.findObject();
	}
	@Override
	public int insertObject(SalesRecord sales) {
		if(sales==null)
			throw new ServiceException("保存数据不能为空");
		if(sales.getCource_id()==null||sales.getCource_id()==0)
			throw new ServiceException("商品不能为空");
		if(sales.getUser_id()==null||sales.getUser_id()==0)
			throw new ServiceException("用户不能为空");
		long time = System.currentTimeMillis();
		String orderNumber = time+Math.random()*100+"";
		sales.setOrderNumber(orderNumber.trim());
		int rows; 
		try {
			rows = salesRecordDao.insertObject(sales);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统出错，请稍后重试");
		}
		return rows;
	}
	
	
	@Override
	public PageObject<SalesRecord> findPageObjects(String orderNumber, Integer pageCurrent) {
		//1.查询总记录数
		int rowCount=salesRecordDao.getRowCount(orderNumber);
		System.out.println("rowCount= "+rowCount);
		if(rowCount==0)
		throw new ServiceException("没有记录");
		//2.查询当前页记录
		//2.1定义页面大小(每页最多现实多少条记录)
		int pageSize=5;
		//2.2计算当前页位置
		if(pageCurrent==null||pageCurrent<=0)
		throw new ServiceException("当前页码不合法");
		int startIndex=(pageCurrent-1)*pageSize;
		//查询当前页
		List<SalesRecord> list = 
				salesRecordDao.findPageObjects(orderNumber, startIndex, pageSize);
		//封装数据
		PageObject<SalesRecord> pageObject = 
				new PageObject<>();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		return pageObject;
	}

}
