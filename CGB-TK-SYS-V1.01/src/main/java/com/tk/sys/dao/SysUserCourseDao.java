package com.tk.sys.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserCourseDao {
    /** insert user_courses info */
    int insertObject(@Param("user_id") Integer user_id, @Param("course_id") Integer course_id,
                     @Param("validity") int validity);

    /** delete course user has buy by user_id */
    int deleteObject(@Param("user_id") Integer user_id, @Param("course_id") Integer course_id);

    /** update valid time by user_id, courses_id */
    int updateObject(@Param("user_id") Integer user_id, @Param("course_id") Integer course_id,
                     @Param("validity") int validity);

    /** find valid by user_id, course_id */
    int findValidityById(@Param("user_id") Integer user_id, @Param("course_id") Integer course_id);
}
