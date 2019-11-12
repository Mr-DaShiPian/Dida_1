package com.qf.service;

import com.qf.pojo.MyClass;

import java.util.List;

public interface SupperUserService {
    //课程管理
    //增加课程
    public int insertClass(MyClass myClass);
    //修改课程
    public int updateClassById(MyClass myClass);
    //删除课程
    public int deleteClass(int id);
    //查看所有课程
    public List<MyClass> selectClass();
    //查看所有课程根据ID
    public List<MyClass> selectClassById(int id);
}
