package com.qf.service;

import com.qf.pojo.Score;
import com.qf.pojo.Leaves;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import com.qf.pojo.User;

import java.util.List;

public interface LectureService {
    public List<Student> getStudentListTable();
    //遍历学生周报
    public List<Weekly> getWeeklyList();
    public List<Weekly> getWeeklyListchart();
    //学生成绩
    public int updatelectureweeklyscore (int wkId,int score);
    //chart走势图
    public List<Weekly> StudentChart(String stuName);
    //班级平均分柱状图
    public List<Score>  ClassChart(Score score);
    //阶段分层
    public List<Weekly> getWeeklyDate();
    ///////////////////
    public List<Leaves> getLeaveByLecture();
    public int agreeLeaves(String instanceId,int lid);
    public String getInstanceId(int lid);
    public String getboosByRole();
    public User getUserByUserName(String userName);
    public int addLeave(Leaves leaves);

}
