package com.nico.springbootprueba.service;

import com.nico.springbootprueba.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    List<Department> getDepartments();
}
