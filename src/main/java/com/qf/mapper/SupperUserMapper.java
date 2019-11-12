package com.qf.mapper;

import com.qf.pojo.MyClass;
import com.qf.pojo.User;
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
    //角色管理
    //增加角色
    public int insertRole(User user);
    //修改角色
    public int updateRoleById(User user);
    //删除角色
    public int deleteRole(int id);
    //查询所有角色
    public List<User> selectRoleList();
    //根据Id查询角色
    public List<User> selectRoleListById(int userId);
    //增加角色 根据用户名或用户id
    public int insertRoleByUser(User user);

}
