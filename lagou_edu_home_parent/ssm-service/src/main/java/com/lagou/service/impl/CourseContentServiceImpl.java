package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    /*6.根据课程ID 查询课程内容(章节与课时)*/
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id) {
        List<CourseSection> list = courseContentMapper.findSectionAndLessonByCourseId(id);

        return list;
    }

    @Override
    /*7.回显章节对应的课程信息*/
    public Course findCourseByCourseId(Integer courseId) {
        Course course = courseContentMapper.findCourseByCourseId(courseId);
        return course;
    }

    @Override
    /*8.新增章节*/
    public void saveSection(CourseSection courseSection) {
        //1.补全信息
        courseSection.setCreateTime(new Date());
        courseSection.setUpdateTime(new Date());
        //2.调用mapper
        courseContentMapper.saveSection(courseSection);
    }

    @Override
    /*9.更新章节*/
    public void updateSection(CourseSection courseSection) {
        //1.补全信息
        courseSection.setUpdateTime(new Date());
        //2.调用mapper
        courseContentMapper.updateSection(courseSection);
    }

    @Override
    /*10.更新章节状态*/
    public void updateSectionStatus(int id, int status) {
        //1.封装数据
        CourseSection courseSection = new CourseSection();
        courseSection.setId(id);
        courseSection.setStatus(status);
        courseSection.setUpdateTime(new Date())
        ;
        //2.调用mapper
        courseContentMapper.updateSectionStatus(courseSection);

    }
}
