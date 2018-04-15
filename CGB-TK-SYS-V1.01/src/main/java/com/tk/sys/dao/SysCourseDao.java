package com.tk.sys.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.tk.sys.entity.SysCourse;
public interface SysCourseDao {
	 /***
	  * @param name 按名字查询时的查询参数
	  * @param startIndex 分页查询时起始页的位置
	  * @param pageSize 每页最多显示多少提交记录
	  * @return
	  */
	 List<SysCourse> findPageObjects(@Param("name") String name);
	 /**所有课程信息*/
	 List<SysCourse> findAllObject();
	 /**统计记录数*/
	 int getRowCount(@Param("name") String name);
	 /**根据id课程id号删除课程,可以多选一起删除*/
	 int deleteObjects(@Param("ids")String[] ids);
	 /**执行insert操作*/
	 int insertObject(SysCourse entity);
	 /**根据id查询角色信息*/
	 SysCourse findObjectById(Integer id);
	 /**根据id 修改角色信息*/
	 int updateObjectById(SysCourse entity);
	 /**该变选中课程的上上架下架状态*/
	 int changeObjectStateById(@Param("id")Integer id,@Param("state")Integer state,@Param("modifiedUser")String modifiedUser);
	
	 /**ccb**/
	 int findRowCount(@Param("type")Integer type,@Param("name") String name);
	 /**ccb**/ 
	 List<SysCourse> findObjectPagesByType
	 (@Param("startIndex")int startIndex,
			 @Param("pageSize")int pageSize,
			 @Param("type")Integer type,
			 @Param("name") String name);
	 
	 /**ccb**/
	int changeObjectStateByIds(
			@Param("ids")String[] ids, 
			@Param("state")Integer state, 
			@Param("modifiedUser")String modifiedUser);
}
