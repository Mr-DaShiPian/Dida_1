package com.qf.service;

import com.qf.pojo.Student;

public interface StudentService {
    public Student getStudentByUserName(String userName);
    public int addStudent(Student student);
    public int updateStudent(Student student);
}
