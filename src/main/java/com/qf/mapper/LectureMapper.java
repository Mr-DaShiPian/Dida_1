package com.qf.mapper;

import com.qf.pojo.*;

import java.util.List;

public interface LectureMapper {
    //学生信息
    public List<Student> getStudentListTable();
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
    public List<Student> getSudentList();
    //////////////
    public List<Leaves> getLeaveByLecture();
    public int agreeLeaves(int lid);
    public String getInstanceId(int lid);
    public String getboosByRole();
    public User getUserByUserName(String userName);
    public int addLeave(Leaves leaves);

}
