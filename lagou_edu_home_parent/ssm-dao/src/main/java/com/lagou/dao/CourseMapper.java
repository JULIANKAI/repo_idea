package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.Teacher;
import com.lagou.domain.Test;

import java.util.List;

public interface CourseMapper {
    /*1.多条件课程列表查询*/
    public List<Course> findCourseByConditioin(CourseVo courseVo);

    /*测试专用*/
    List<Test> findTest();

    /*2.新增课程信息*/
    public void  saveCourse(Course course);

    /*.新增加老师信息*/
    public void saveTeacher(Teacher teacher);

    /*3.回显示课程信息及老师信息,根据id 获取课程信息 */
    public CourseVo findCourseById(Integer id);

    /*4.更新课程信息*/
    public void updateCourse(Course course);

    /*.更新老师信息*/
    public void updateTeacher(Teacher teacher);

    /*5.课程管理状态修改*/
    public void updateCourseStatus(Course course);
}
