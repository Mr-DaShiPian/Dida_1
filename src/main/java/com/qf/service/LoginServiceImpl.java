package com.qf.service;

import com.qf.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public String getUpwdByUserName(String userName) {
        return loginMapper.getUpwdByUserName(userName);
    }

    @Override
    public String getRolenameByUserName(String userName) {
        return loginMapper.getRolenameByUserName(userName);
    }

    @Override
    public int updatePassword(String password,String userName) {
        return loginMapper.updatePassword(password,userName);
    }
}
