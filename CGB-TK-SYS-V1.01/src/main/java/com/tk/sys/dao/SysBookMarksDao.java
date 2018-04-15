package com.tk.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;




public interface SysBookMarksDao {
	List<Integer> findBookMarks(Integer user_id);
	
	int insertBookMark(
			@Param("user_id")Integer user_id,
			@Param("course_id")Integer course_id);
	
	int deleteBookMark(Integer id);
}
