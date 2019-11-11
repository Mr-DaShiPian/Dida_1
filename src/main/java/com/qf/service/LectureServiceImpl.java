package com.qf.service;

import com.qf.mapper.LectureMapper;
import com.qf.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LectureServiceImpl implements LectureService {
    @Autowired
    private LectureMapper lectureMapper;
    @Override
    public List<Student> getStudentList() {
        return lectureMapper.getSudentList();
    }
}
