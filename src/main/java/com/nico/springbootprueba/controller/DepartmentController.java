package com.nico.springbootprueba.controller;

import com.nico.springbootprueba.entity.Department;
import com.nico.springbootprueba.error.DepartmentNotFoundException;
import com.nico.springbootprueba.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") int id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") int id) {
        departmentService.deleteDepartmentById(id);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") int id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        return departmentService.getDepartmentByName(name);
    }
}
