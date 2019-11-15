package com.qf.service;

import com.qf.mapper.HeadTeacherMapper;
import com.qf.mapper.LectureMapper;
import com.qf.pojo.*;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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



    ////////////////
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public List<Leaves> getLeaveByLecture() {
        return headTeacherMapper.getLeaveByLecture();
    }

    @Override
    public int agreeLeaves(String instanceId,int lid) {
        String id = taskService.createTaskQuery().processInstanceId(instanceId).singleResult().getId();
        taskService.complete(id);
        return headTeacherMapper.agreeLeaves(lid);
    }

    @Override
    public String getInstanceId(int lid) {
        return headTeacherMapper.getInstanceId(lid);
    }

    @Override
    public String getboosByRole() {
        return headTeacherMapper.getboosByRole();
    }

    @Override
    public User getUserByUserName(String userName) {
        return headTeacherMapper.getUserByUserName(userName);
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
        return headTeacherMapper.addLeave(leaves);
    }
}
