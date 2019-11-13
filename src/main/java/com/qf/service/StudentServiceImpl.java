package com.qf.service;

import com.qf.mapper.StudentMapper;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student getStudentByUserName(String userName) {
        return studentMapper.getStudentByUserName(userName);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int updateUserByName(String name,String password) {
        return studentMapper.updateUserByName(name,password);
    }

    @Override
    public List<Weekly> getWeeklyByName(String name) {
        return studentMapper.getWeeklyByName(name);
    }

    @Override
    public Weekly getWeeklyById(int id) {
        return studentMapper.getWeeklyById(id);
    }

    @Override
    public int delWeeklyById(int id) {
        return studentMapper.delWeeklyById(id);
    }

    @Override
    public int addWeekly(Weekly weekly) {
        return studentMapper.addWeekly(weekly);
    }
}
