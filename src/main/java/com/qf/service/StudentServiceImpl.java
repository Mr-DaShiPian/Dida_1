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
    public List<Weekly> getWeeklyByName(String name) {
        return studentMapper.getWeeklyByName(name);
    }
}
