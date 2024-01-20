package com.nico.springbootprueba.service;

import com.nico.springbootprueba.entity.Department;
import com.nico.springbootprueba.error.DepartmentNameExistsException;
import com.nico.springbootprueba.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department save(Department department) throws DepartmentNameExistsException;

    List<Department> getDepartments();

    Department getDepartmentById(int id) throws DepartmentNotFoundException;

    void deleteDepartmentById(int id) throws DepartmentNotFoundException;

    Department updateDepartment(int id, Department department) throws DepartmentNotFoundException, DepartmentNameExistsException;

    Department getDepartmentByName(String name);
}
