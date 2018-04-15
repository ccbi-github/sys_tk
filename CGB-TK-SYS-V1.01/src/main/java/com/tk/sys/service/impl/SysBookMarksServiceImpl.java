package com.tk.sys.service.impl;
/**
 * 收藏功能实现类
 */
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tk.sys.dao.SysBookMarksDao;
import com.tk.sys.service.SysBookMarksService;

@Service
public class SysBookMarksServiceImpl implements SysBookMarksService{
	
	@Autowired
	private SysBookMarksDao sysBookMarksDao;

	@Override
	public int insertBookMark(Integer user_id, Integer course_id) {
		int rows = sysBookMarksDao.insertBookMark(user_id, course_id);
		return rows;
	}

	@Override
	public int deleteBookMark(Integer id) {
		int rows = sysBookMarksDao.deleteBookMark(id);
		return rows;
	}


	@Override
	public List<Integer> findBookMarks(Integer user_id) {
		return sysBookMarksDao.findBookMarks(user_id);
	}
	
}


