package com.tk.sys.service;

import java.util.List;

import com.tk.common.vo.PageObject;
import com.tk.sys.entity.SalesRecord;

public interface SalesRecordService {
	int updateObject(SalesRecord sales);
	PageObject<SalesRecord> findPageObjects(
			String orderNumber,Integer PageCurrent);
	int insertObject(SalesRecord sales);
	List<SalesRecord> findObject();
}
