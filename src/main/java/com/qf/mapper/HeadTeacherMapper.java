package com.qf.mapper;

import com.qf.pojo.MyClass;
import com.qf.pojo.Student;
import com.qf.pojo.StudentAndClass;
import com.qf.pojo.Weekly;

import java.util.List;
import java.util.Map;

public interface HeadTeacherMapper {

    //得到所有周报
    public List<Weekly> getAllWeekly();
    //根据日期获取周报
    public List<Weekly> getWeeklyByWeekDate(String weekDate);
    //根据姓名获取周报
    public List<Weekly> getWeeklyByStuName(String stuName);
    //根据姓名和日期获取周报
    public Weekly getWeeklyByDateAndStuName(String weekDate,String stuName);
    //根据姓名得到学生信息
    public Student getStudentByStuName(String stuName);
    //根据cid得到班级信息
    public MyClass getMyClassByCid(String cid);
    //查询所有班级的集合
    public List<String> getClassBy();
    //根据班级查询该班级的学生
    public List<Student> getStudentByCid(String cid);
    //根据班级查询对应学生 (一对多)
    public List<StudentAndClass> getStudentAndClass();
    //更新学生信息
    public int updateStudent(Student student);
    //删除学生信息
    public int deleteStudent(int stuId);
    //查询所有学生
    public List<Student> getStudentList();
    //添加学生
    public int addStudent(Student student);
    //根据日期和学生姓名查询每个学生的周报成绩
    public List<Weekly> getGradeByDate(Map<String,Object> map);

}
