package com.qf.mapper;

import com.qf.pojo.MyClass;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;

import java.util.List;

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
    public MyClass getMyClassByCid(int cid);


}
