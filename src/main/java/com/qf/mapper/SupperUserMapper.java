package com.qf.mapper;

import com.qf.pojo.MyClass;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;
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
    public List<User> selectRoles();
    //根据Id查询角色
    public List<User> selectRoleListById(int userId);
    //增加角色 根据用户名或用户id
    public int insertRoleByUser(User user);
    //根据userID修改用户角色
    public int updateRoleByUserId(int userId);
    //员工管理(user表里的role和userName)
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
    //班级管理
    //查看所有的班级
    public List<MyClass> selectClassByCid();
    //增加班级
    public int insertClass2(MyClass myClass);
    //分配讲师和班主任 本质就是修改
    public int updateClass2(MyClass myClass);
    //根据cid查询班级
    public List<MyClass> selectClassByCid2(String cid);
    //用户管理, 查询需求
    public List<User> seleuserManager();
    public List<User> seleuserManagerByUname(String userName);
    //增加用户
    public int insertManager(User user);
    //
    public int updateManager(@Param(value = "password") String password, @Param(value = "userName") String userName);
    //用户表的删除
    public int deleteManager(int userId);
    //根据id 修改密码
    public int updateManagerByUserId(@Param(value = "password") String password,@Param(value = "userId") int userId);
    //根据userName 查询是学生的姓名
    public String selectManagerByUserName(@Param(value = "userName")String userName);

    public List<Student> selectStudentList(String stuName);

}
