package com.dept.app.controller;


import com.dept.app.entity.Department;
import com.dept.app.service.DepartmentService;
import com.dept.app.service.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dept")
public class DeptController {

   @Autowired
   DepartmentService departmentService;

//    @GetMapping("/")
//    public String getDept() {
//        return "dept-controller";
//    }

    @GetMapping("/{id}")
    public Department getbyid(@PathVariable("id") int deptid) {
        return departmentService.getByid(deptid);
    }

    @GetMapping("/all")
    public List<Department> Alldept() {
        return departmentService.AllDept();
    }

    @PostMapping("/add")
    public Department AddDept(@RequestBody Department department) {
        Department savedDept = departmentService.CreateDept(department);
        return savedDept;
    }


}
