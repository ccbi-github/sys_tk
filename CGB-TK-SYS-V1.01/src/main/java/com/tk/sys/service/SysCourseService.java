package com.tk.sys.service;
import com.github.pagehelper.PageInfo;
import com.tk.common.vo.PageObject;
import com.tk.sys.entity.SysCourse;
public interface SysCourseService {
	/**
	 * 查询课程
	 * @param name 课程名
	 * @param pageNum 当前页
	 * @return
	 */
	 PageInfo findPageObjects(String name,Integer pageNum);
	 /**
	  * 根据id删除客户课程，可多选删除
	  * @param ids：被选中课程的id号
	  * @return
	  */
	 int deleteObjects(String ids);
	 int insertObject(SysCourse entity);
	 /**
	  * 修改选中的课程信息
	  * @param entity
	  * @return
	  */
	 int updateObjectById(SysCourse entity);
	 /**
	  * 通过id查询课程资料
	  */
	 SysCourse findObjectById(Integer id);
	 /**
	  * 通过id号，修改课程上下架状态 
	  */
	 int changeStateById(Integer id,Integer state,String modiferUser);
	 
	 /** Export Courses*/
	 void exportCourses();
	 
	PageObject findObjectPagesByType(Integer pageCurrent, Integer type,String name);
	void changeStateByIds( String ids, Integer state, String modifiedUser);
	 
	 /**ccb **/
	 
}
