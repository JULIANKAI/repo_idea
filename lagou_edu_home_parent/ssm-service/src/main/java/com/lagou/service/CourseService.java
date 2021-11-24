package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {
    /*1.多条件课程列表查询*/
    public List<Course> findCourseByConditioin(CourseVo courseVo);

    /*2.新增课程信息*/
    List<Test> findTest();

    /*新增课程和老师课程*/
    public void saveCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    /*3.回显示课程信息及老师信息,根据id 获取课程信息 */
    public CourseVo findCourseById(int id);

    /*4更新课程和老师课程*/
    public void updateCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    /*5.课程管理状态修改*/
    public void updateCourseStatus(int courseid,int status);
}
