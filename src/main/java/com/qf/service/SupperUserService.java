package com.qf.service;

import com.qf.pojo.MyClass;
import com.qf.pojo.User;

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
    //角色管理
    //增加角色
    public int insertRole(User user);
    //修改角色
    public int updateRoleById(User user);
    //删除角色
    public int deleteRole(int id);
    //查询所有角色
    public List<User> selectRoleList();
    public List<User> selectRoles();
    //根据Id查询角色
    public List<User> selectRoleListById(int userId);
    //增加角色 根据用户名或用户id
    public int insertRoleByUser(User user);
    //查看员工(姓名和角色,排除role=学生)
    public List<User> selectStaff();
    //增加员工
    public int insertStaff(User user);
    //根据id修改员工信息
    public int updateStaff(User user);
    //根据id查询员工信息
    public List<User> selectStaffByUserId(int userId);
    //根据名字查询员工信息
    public List<User> selectStaffByUname(User user);
    //查看所有的班级
    public List<MyClass> selectClassByCid();
    //增加班级
    public int insertClass2(MyClass myClass);
}
