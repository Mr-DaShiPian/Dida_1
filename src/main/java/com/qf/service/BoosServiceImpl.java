package com.qf.service;

import com.qf.mapper.BoosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
