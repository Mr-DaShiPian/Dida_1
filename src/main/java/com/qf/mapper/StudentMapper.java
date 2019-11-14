package com.qf.mapper;

import com.qf.pojo.Leaves;
import com.qf.pojo.MyClass;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;

import java.util.List;

public interface StudentMapper {
    //通过姓名得到学生信息
    public Student getStudentByUserName(String userName);
    //添加学生信息
    public int addStudent(Student student);
    //修改学生信息
    public int updateStudent(Student student);
    //通过用户名改密码
    public int updateUserByName(String name,String password);
    //根据学生姓名查周报
    public List<Weekly> getWeeklyByName(String name);
    //根据周报wkId查单条数据
    public Weekly getWeeklyById(int id);
    //根据周报Id删数据
    public int delWeeklyById(int id);
    //新建周报
    public int addWeekly(Weekly weekly);
    //得到校长姓名
    public String getboosByRole();
    //添加学生假条
    public int addLeave(Leaves leaves);
    //通过cid查班级表
    public MyClass selMyClassByCid(String cid);
}
