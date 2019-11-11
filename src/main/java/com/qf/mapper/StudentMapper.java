package com.qf.mapper;

import com.qf.pojo.Student;

public interface StudentMapper {
    //通过姓名得到学生信息
    public Student getStudentByUserName(String userName);
    //添加学生信息
    public int addStudent(Student student);
}
