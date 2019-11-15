package com.qf.service;

import com.qf.mapper.LectureMapper;
import com.qf.pojo.*;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LectureServiceImpl implements LectureService {
    @Autowired
    private LectureMapper lectureMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Override
    public List<Student> getStudentListTable() {
        return lectureMapper.getStudentListTable();
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

    ///////////////////////

    @Override
    public List<Leaves> getLeaveByLecture() {
        return lectureMapper.getLeaveByLecture();
    }

    @Override
    public int agreeLeaves(String instanceId,int lid) {
        String id = taskService.createTaskQuery().processInstanceId(instanceId).singleResult().getId();
        taskService.complete(id);
        return lectureMapper.agreeLeaves(lid);
    }

    @Override
    public String getInstanceId(int lid) {
        return lectureMapper.getInstanceId(lid);
    }
    @Override
    public String getboosByRole() {
        return lectureMapper.getboosByRole();
    }

    @Override
    public User getUserByUserName(String userName) {
        return lectureMapper.getUserByUserName(userName);
    }

    @Override
    public int addLeave(Leaves leaves) {
        Map<String, Object> map = new HashMap<>();
        map.put("teacher",leaves.getStuName());
        map.put("boos",leaves.getBoos());
        //发起流程实例
        runtimeService.startProcessInstanceByKey("teacherProcess", map);
        String id = taskService.createTaskQuery().taskAssignee(leaves.getStuName()).singleResult().getId();
        String instanceId = taskService.createTaskQuery().taskAssignee(leaves.getStuName()).singleResult().getProcessInstanceId();
        //完成请假任务
        taskService.complete(id);
        leaves.setInstanceId(instanceId);
        return lectureMapper.addLeave(leaves);
    }
    @Override
    public int selectProcess(String name) {
        List<Task> list = taskService.createTaskQuery().taskAssignee(name).list();
        return list.size();
    }
}
