package com.dept.app.service;

import com.dept.app.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DeptRepo repo;

    public List<Department> AllDept() {
        return repo.findAll();
    }

    public Department CreateDept(Department department) {
        return repo.save(department);
    }

    public Department getByid(int deptid) {
        return repo.findById(deptid).get();
    }
}
