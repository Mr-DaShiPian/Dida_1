package com.qf.service;

import com.qf.pojo.Student;
import com.qf.pojo.Weekly;

import java.util.List;

public interface StudentService {
    public Student getStudentByUserName(String userName);
    public int addStudent(Student student);
    public int updateStudent(Student student);
    public List<Weekly> getWeeklyByName(String name);

}
