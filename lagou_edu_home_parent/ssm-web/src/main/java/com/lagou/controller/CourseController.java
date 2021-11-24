package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Test;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /*1.多条件课程列表查询*/
    @RequestMapping("/findAllCourse")
    public ResponseResult findCourseByConditioin(@RequestBody CourseVo courseVO){
        System.out.println("00000011112222333......");
        List<Course> list = courseService.findCourseByConditioin(courseVO);
        System.out.println("11111112222.....");
        System.out.println(list);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", list);
        return result;

    }
    /*测试*/
    @RequestMapping("/findTest")
    public List<Test> findTest(){
       List<Test> test =  courseService.findTest();
       return test;
    }

    /*图片上传接口*/
 /*   @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){

        try {
            *//*1.判断文件是否为空*//*
            if(file.isEmpty()){
                throw  new RuntimeException();
            }

            *//*2.获取项目部署的路径*//*
            *//* 2.1 D:\apache-tomcat-8.5.56\webapps\ssm_web\ *//*
            String realpath = request.getServletContext().getRealPath("/");
            //2.2截取路径.// D:\apache-tomcat-8.5.56\webapps\
            String webappsPath =  realpath.substring(0, realpath.indexOf("ssm_web"));

            *//*3.获取原文件名*//*
            String fileName = file.getOriginalFilename();

            *//*4.新文件名*//*
            String newFileName =  System.currentTimeMillis()+ fileName.substring(fileName.lastIndexOf("."));

            *//*5上传文件*//*
            String uploadPath = webappsPath+ "upload\\";
            File filePath =  new File(uploadPath,newFileName);

            //如果目录不存在就创建目录
            if(!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录："+filePath);
            }

            //图片进行真正的上传
            file.transferTo(filePath);

            *//*6.将文件名和文件路径返回*//*
            HashMap<String, String> map = new HashMap<>();
            map.put("fileName",newFileName);
            map.put("filePath","http://localhost:8080/upload/"+newFileName);
            ResponseResult result = new ResponseResult(true, 200, "图片上传成功", map);

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }*/

     /**    
     * 2.保存 & 4.修改课程信息接口
      */
     @RequestMapping("/saveOrUpdateCourse")
     public ResponseResult saveOrUpdateCourse(@RequestBody CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {
         //判断封装的实体是否有id的值用于区别是新增操作还是更新操作
         if (courseVo.getId() == null){
             courseService.saveCourse(courseVo);
             ResponseResult result = new ResponseResult(true, 200, "新增成功", null);
             return result;
         }
         else {
             courseService.updateCourse(courseVo);
             ResponseResult result = new ResponseResult(true, 200, "更新成功", null);
             return result;
         }

     }


     /**
     *  3.回显示课程信息及老师信息,根据id 获取课程信息
      */
     @RequestMapping("/findCourseById")
     public ResponseResult findCourseById(Integer id){
         CourseVo courseVo = courseService.findCourseById(id);
         ResponseResult result = new ResponseResult(true, 200, "回显课程及老师信息成功", courseVo);
         return result;
     }

    /**
     *  .课程管理状态修改
     */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id,Integer status){
        //执行修改操作
        courseService.updateCourseStatus(id,status);

        //保存修改后的状态,并返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("status",status);
        ResponseResult result = new ResponseResult(true, 200, "课程管理修改成功", map);
        return result;

    }
}
