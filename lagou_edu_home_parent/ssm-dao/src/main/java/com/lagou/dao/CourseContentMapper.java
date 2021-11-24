package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {
    /*6.根据课程ID 查询课程内容(章节与课时)*/
    public List<CourseSection>  findSectionAndLessonByCourseId(Integer id);

    /*7.回显章节对应的课程信息*/
    public Course  findCourseByCourseId(Integer courseId);

    /*8.新增章节*/
    public void saveSection(CourseSection courseSection);

    /*9.更新章节*/
    public void updateSection(CourseSection courseSection);

    /*10.修改章节状态*/
    public void  updateSectionStatus(CourseSection courseSection);
}
