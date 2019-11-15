package com.qf.service;

import com.qf.pojo.Leaves;

import java.util.List;

public interface BoosService {
    //通过用户名改密码
    public int updateUserByName(String name,String password);
    ///////////////////
    public List<Leaves> getLeaveByLecture();
    public int agreeLeaves(String instanceId,int lid);
    public String getInstanceId(int lid);
}
