package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.Teacher;
import com.lagou.domain.Test;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    /*1.多条件课程列表查询*/
    @Override
    public List<Course> findCourseByConditioin(CourseVo courseVo) {
        List<Course> courseByConditioin = courseMapper.findCourseByConditioin(courseVo);
        return courseByConditioin;
    }

    /*测试*/
    @Override
    public List<Test> findTest() {
        return courseMapper.findTest();
    }

    /*2.新建课程老师信息*/
    @Override
    public void saveCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        //利用beanutils的copyProperties接口把传过的对象属性赋值到course
        BeanUtils.copyProperties(course,courseVo);
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        //保存课程
        courseMapper.saveCourse(course);

        // //获取新插入数据的id
        int id = course.getId();

        //封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVo);
        //补全信息
        teacher.setCourseId(id);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);

        //保存讲师信息
        courseMapper.saveTeacher(teacher);

    }

    /*3.回显示课程信息及老师信息,根据id 获取课程信息 */
    @Override
    public CourseVo findCourseById(int id) {
        return courseMapper.findCourseById(id);
    }

    /*4更新课程和老师课程*/
    @Override
    public void updateCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        //把courseVo中的属性复制一份到course中
        BeanUtils.copyProperties(course,courseVo);
        //补全信息
        Date date = new Date();
        course.setUpdateTime(date);
        //更新课程
        courseMapper.updateCourse(course);

        //封装老师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVo);
        //补全信息
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        //更新老师信息
        courseMapper.updateTeacher(teacher);

    }

    @Override
    public void updateCourseStatus(int courseid, int status) {
        //1.封装数据
        Course course = new Course();
        course.setId(courseid);
        course.setStatus(status);
        course.setUpdateTime(new Date());

        //2.调用mapper
        courseMapper.updateCourseStatus(course);
    }
}
