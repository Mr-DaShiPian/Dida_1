package com.qf.service;

import com.qf.mapper.HeadTeacherMapper;
import com.qf.pojo.MyClass;
import com.qf.pojo.Student;
import com.qf.pojo.StudentAndClass;
import com.qf.pojo.Weekly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HeadTeacherServiceImpl implements HeadTeacherService{
    @Autowired
    private HeadTeacherMapper headTeacherMapper;

    @Override
    public List<Weekly> getAllWeekly() {
        return headTeacherMapper.getAllWeekly();
    }

    @Override
    public List<Weekly> getWeeklyByWeekDate(String weekDate) {
        return headTeacherMapper.getWeeklyByWeekDate(weekDate);
    }

    @Override
    public List<Weekly> getWeeklyByStuName(String stuName) {
        return headTeacherMapper.getWeeklyByStuName(stuName);
    }

    @Override
    public Weekly getWeeklyByDateAndStuName(String weekDate, String stuName) {
        return headTeacherMapper.getWeeklyByDateAndStuName(weekDate, stuName);
    }

    @Override
    public Student getStudentByStuName(String stuName) {
        return headTeacherMapper.getStudentByStuName(stuName);
    }

    @Override
    public MyClass getMyClassByCid(String cid) {
        return headTeacherMapper.getMyClassByCid(cid);
    }

    @Override
    public List<String> getClassBy() {
        return headTeacherMapper.getClassBy();
    }

    @Override
    public List<Student> getStudentByCid(String cid) {
        return headTeacherMapper.getStudentByCid(cid);
    }

    @Override
    public List<StudentAndClass> getStudentAndClass() {
        return headTeacherMapper.getStudentAndClass();
    }

    @Override
    public int updateStudent(Student student) {
        return headTeacherMapper.updateStudent(student);
    }
    @Override
    public int deleteStudent(int stuId) {
        return headTeacherMapper.deleteStudent(stuId);
    }

    @Override
    public List<Student> getStudentList() {
        return headTeacherMapper.getStudentList();
    }

    public int addStudent(Student student){
        return headTeacherMapper.addStudent(student);
    }

    @Override
    public List<Weekly> getGradeByDate(Map<String,Object> map) {
        return headTeacherMapper.getGradeByDate(map);
    }

}
