package com.qf.mapper;

public interface LoginMapper {
    //根据用户名获取密码
    public String getUpwdByUserName(String userName);
    //根据用户名查权限
    public String getRolenameByUserName(String userName);
    //修改密码
    public int updatePassword(String password,String userName);
}
