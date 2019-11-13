package com.qf.service;

import com.qf.pojo.Student;
import com.qf.pojo.Weekly;

import java.util.List;

public interface StudentService {
    public Student getStudentByUserName(String userName);
    public int addStudent(Student student);
    public int updateStudent(Student student);
    public int updateUserByName(String name,String password);
    public List<Weekly> getWeeklyByName(String name);
    public Weekly getWeeklyById(int id);
    public int delWeeklyById(int id);
    public int addWeekly(Weekly weekly);


}
