package com.tk.sys.service.impl;

import com.tk.sys.common.exception.ServiceException;
import com.tk.sys.dao.SysUserCourseDao;
import com.tk.sys.service.SysUserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class SysUserCourseServiceImpl implements SysUserCourseService {
    @Autowired
    private SysUserCourseDao sysUserCourseDao;

    @Override
    public int saveObject(Integer user_id, Integer course_id, Integer validity) {
        // 插入用户已购买课程
        int rows = sysUserCourseDao.insertObject(user_id, course_id, validity);
        return rows;
    }

    @Override
    public int deleteObject(Integer user_id, Integer course_id) {
        // 1.判断数据合法性
    	if (StringUtils.isEmpty(user_id)
                || StringUtils.isEmpty(course_id)) {
            throw new ServiceException("用户或课程不能为空");
        }
        // 2.当课程失效，删除用户的课程
    	int rows = sysUserCourseDao.deleteObject(user_id, course_id);
    	return rows;
    }

    @Override
    public int updateObject(Integer user_id, Integer course_id, Integer validity) {
    	if (StringUtils.isEmpty(user_id)
                || StringUtils.isEmpty(course_id)
                || StringUtils.isEmpty(validity)) {
            throw new ServiceException("用户，课程和有效时间不能为空");
        }
    	sysUserCourseDao.deleteObject(user_id, course_id);
    	int rows = sysUserCourseDao.insertObject(user_id, course_id, validity);
    	return rows;
    }

	@Override
	public int findCourseValid(Integer user_id, Integer course_id) {
		if (StringUtils.isEmpty(user_id)
                || StringUtils.isEmpty(course_id)) {
            throw new ServiceException("用户和课程不能为空");
        }
		int validity = sysUserCourseDao.findValidityById(user_id, course_id);
		return validity;
	}
}
