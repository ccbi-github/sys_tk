package com.tk.common.vo;

import java.util.List;

/**
 * VO:Value Object (值对象)
 * 借助此对象封装当前页数据以及分页信息
 * 
 * 泛型:编译时的一种类型,运行时无效,JDK1.5推出,
 * 泛型类型:
 * 1)泛型类:直接定义在类或接口上(例如  类名<泛型>)
 * 2)泛型方法:直接定义在方法上的泛型,
 * 要定义在方法的返回值类型左侧(例如 <泛型>void print(泛型 t))
 * 
 * 泛型应用场景:
 * 1)通用编程(让代码更加通用,更加友好):以不变应万变
 * 2)是实现性能优化的一种手段
 * */
public class PageObject<T> {
	/**当前页的记录*/
	private Object records;
	/**总页数(计算)*/
	private int pageCount;
	/**总记录数(从数据库获取)*/
	private int rowCount;
	/**当前页的页码(从页面获取)*/
	private int pageCurrent;
	
	private int pageSize=3;

	
	public Object getRecords() {
		return records;
	}
	public void setRecords(Object records) {
		this.records = records;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0)
			pageCount++;
		return pageCount;
	}
	 
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	@Override
	public String toString() {
		return "PageObject [records=" + records + ", pageCount=" + pageCount + ", rowCount=" + rowCount
				+ ", pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + "]";
	}
	
	

}







