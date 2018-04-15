package com.tk.sys.service;

public interface SysUserCourseService {
    /** save object by user_id, course_id, validity */
    int saveObject(Integer user_id, Integer course_id,
                   Integer validity);

    /** delete object by user_id and course_id */
    int deleteObject(Integer user_id, Integer course_id);

    /** update valid time by user_id and course_id */
    int updateObject(Integer user_id, Integer course_id,
                     Integer validity);
    
    int findCourseValid(Integer user_id, Integer course_id);
}
