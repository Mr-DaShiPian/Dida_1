package com.qf.service;

import com.qf.mapper.SupperUserMapper;
import com.qf.pojo.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupperUserServiceImpl implements SupperUserService {
    @Autowired
    private SupperUserMapper supperUserMapper;

    public SupperUserMapper getSupperUserMapper() {
        return supperUserMapper;
    }

    public void setSupperUserMapper(SupperUserMapper supperUserMapper) {
        this.supperUserMapper = supperUserMapper;
    }

    @Override
    public int insertClass(MyClass myClass) {
        return supperUserMapper.insertClass(myClass);
    }

    @Override
    public int updateClassById(MyClass myClass) {
        return supperUserMapper.updateClassById(myClass);
    }

    @Override
    public int deleteClass(int id) {
        return supperUserMapper.deleteClass(id);
    }

    @Override
    public List<MyClass> selectClass() {
        return supperUserMapper.selectClass();
    }

    @Override
    public List<MyClass> selectClassById(int id) {
        return supperUserMapper.selectClassById(id);
    }
}
