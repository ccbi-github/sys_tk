package com.tk.sys.service;

import java.util.List;




public interface SysBookMarksService {
	List<Integer> findBookMarks(Integer user_id);

	int insertBookMark(Integer user_id,Integer course_id);
	
	int deleteBookMark(Integer id);	
}
