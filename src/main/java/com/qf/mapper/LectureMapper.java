package com.qf.mapper;

import com.hazelcast.core.LifecycleService;
import com.qf.pojo.Student;

import java.util.List;

public interface LectureMapper {
    public List<Student> getSudentList();
}
