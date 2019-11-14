package com.qf.service;

import com.qf.mapper.SupperUserMapper;
import com.qf.pojo.MyClass;
import com.qf.pojo.User;
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
    //角色管理
    @Override
    public int insertRole(User user) {
        return supperUserMapper.insertRole(user);
    }

    @Override
    public int updateRoleById(User user) {
        return supperUserMapper.updateRoleById(user);
    }

    @Override
    public int deleteRole(int id) {
        return supperUserMapper.deleteRole(id);
    }

    @Override
    public List<User> selectRoleList() {
        return supperUserMapper.selectRoleList();
    }

    @Override
    public List<User> selectRoles() {
        return supperUserMapper.selectRoles();
    }

    @Override
    public List<User> selectRoleListById(int userId) {
        return supperUserMapper.selectRoleListById(userId);
    }

    @Override
    public int insertRoleByUser(User user) {
        return supperUserMapper.insertRoleByUser(user);
    }

    @Override
    public List<User> selectStaff() {
        return supperUserMapper.selectStaff();
    }

    @Override
    public int insertStaff(User user) {
        return supperUserMapper.insertStaff(user);
    }

    @Override
    public int updateStaff(User user) {
        return supperUserMapper.updateStaff(user);
    }

    @Override
    public List<User> selectStaffByUserId(int userId) {
        return supperUserMapper.selectStaffByUserId(userId);
    }

    @Override
    public List<User> selectStaffByUname(User user) {
        return supperUserMapper.selectStaffByUname(user);
    }

    @Override
    public List<MyClass> selectClassByCid() {
        return supperUserMapper.selectClassByCid();
    }

    @Override
    public int insertClass2(MyClass myClass) {
        return supperUserMapper.insertClass2(myClass);
    }

    @Override
    public int updateClass2(MyClass myClass) {
        return supperUserMapper.insertClass2(myClass);
    }

    @Override
    public List<MyClass> selectClassByCid2(String cid) {
        return supperUserMapper.selectClassByCid2(cid);
    }

}
