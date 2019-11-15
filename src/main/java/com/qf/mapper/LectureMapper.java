package com.qf.mapper;

import com.qf.pojo.Score;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;

import java.util.List;

public interface LectureMapper {
    //学生信息
    public List<Student> getStudentList();
    //学生周报
    public List<Weekly>  getWeeklyList();
    public List<Weekly>  getWeeklyListchart();
    //学生成绩
    public int updatelectureweeklyscore (int wkId,int score);
    //成绩走势图
    public List<Weekly> StudentChart(String stuName );
    //成绩柱状图
    public List<Score> ClassChart(Score score);
    //阶段分层
    public List<Weekly> getWeeklyDate();
}
