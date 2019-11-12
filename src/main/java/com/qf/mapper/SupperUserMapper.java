package com.qf.mapper;

import com.qf.pojo.MyClass;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface SupperUserMapper {
    //课程管理
    //增加课程
    public int insertClass(MyClass myClass);
    //修改课程
    public int updateClassById(MyClass myClass);
    //删除课程
    public int deleteClass(int id);
    //查看所有课程
    public List<MyClass> selectClass();
    //根据id查询对应的课程信息用于修改提示
    public List<MyClass> selectClassById(int id);

}
