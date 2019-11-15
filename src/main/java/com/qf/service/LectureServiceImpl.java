package com.qf.service;

import com.qf.mapper.LectureMapper;
import com.qf.pojo.Score;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LectureServiceImpl implements LectureService {
    @Autowired
    private LectureMapper lectureMapper;
    @Override
    public List<Student> getStudentList() {
        return lectureMapper.getStudentList();
    }
    @Override
    public List<Weekly> getWeeklyList(){return lectureMapper.getWeeklyList();}
    @Override
    public List<Weekly> getWeeklyListchart(){return lectureMapper.getWeeklyListchart();}
    @Override
    //学生成绩
    public int updatelectureweeklyscore (int wkId,int score){return  lectureMapper.updatelectureweeklyscore(wkId,score);}

    @Override
    public List<Weekly> StudentChart(String stuName) { return lectureMapper.StudentChart(stuName); }

    @Override
    public List<Score> ClassChart(Score score) { return lectureMapper.ClassChart(score); }

    @Override
    //阶段分层
    public List<Weekly> getWeeklyDate(){return lectureMapper.getWeeklyDate();}

}
