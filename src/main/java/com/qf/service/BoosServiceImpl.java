package com.qf.service;

import com.qf.mapper.BoosMapper;
import com.qf.pojo.Leaves;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoosServiceImpl implements BoosService{
    @Autowired
    private BoosMapper boosMapper;

    public BoosMapper getBoosMapper() {
        return boosMapper;
    }

    public void setBoosMapper(BoosMapper boosMapper) {
        this.boosMapper = boosMapper;
    }

    @Override
    public int updateUserByName(String name, String password) {
        return boosMapper.updateUserByName(name, password);
    }
    ///////////////////////
    @Autowired
    private TaskService taskService;
    @Override
    public List<Leaves> getLeaveByLecture() {
        return boosMapper.getLeaveByLecture();
    }

    @Override
    public int agreeLeaves(String instanceId,int lid) {
        String id = taskService.createTaskQuery().processInstanceId(instanceId).singleResult().getId();
        taskService.complete(id);
        return boosMapper.agreeLeaves(lid);
    }

    @Override
    public String getInstanceId(int lid) {
        return boosMapper.getInstanceId(lid);
    }
}
