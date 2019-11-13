package com.qf.service;

import com.qf.pojo.Score;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;

import java.util.List;

public interface LectureService {
    //遍历学生信息
    public List<Student> getStudentList();
    //遍历学生周报
    public List<Weekly> getWeeklyList();
    public List<Weekly> getWeeklyListchart();
    //学生成绩
    public int updatelectureweeklyscore (int wkId,int score);
    //chart走势图
    public List<Weekly> StudentChart(String stuName);

    public List<Score>  ClassChart(Score score);
}
