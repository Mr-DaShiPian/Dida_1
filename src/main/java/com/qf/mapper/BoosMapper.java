package com.qf.mapper;

import com.qf.pojo.Leaves;

import java.util.List;

public interface BoosMapper {
    //通过用户名改密码
    public int updateUserByName(String name,String password);
    /////////////
    public List<Leaves> getLeaveByLecture();
    public int agreeLeaves(int lid);
    public String getInstanceId(int lid);
}
