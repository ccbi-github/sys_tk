package com.tk.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tk.sys.entity.SalesRecord;


public interface SalesRecordDao {
	int updateObject(SalesRecord sales);
	List<SalesRecord> findPageObjects(
			@Param("orderNumber")String orderNumber,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
	List<SalesRecord> findObject();
	/**
	 * 插入数据
	 * @param sales
	 * @return
	 */
	int insertObject(SalesRecord sales);
	int getRowCount(@Param("orderNumber") String orderNumber);
}
