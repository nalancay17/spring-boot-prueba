package com.nico.springbootprueba.service;

import com.nico.springbootprueba.entity.Department;
import com.nico.springbootprueba.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(int id, Department department) {
        Department depDb = departmentRepository.findById(id).get();
        if (department.getName() != null && !department.getName().isEmpty())
            depDb.setName(department.getName());
        if (department.getAddress() != null && !department.getAddress().isEmpty())
            depDb.setAddress(department.getAddress());
        if (department.getCode() != null && !department.getCode().isEmpty())
            depDb.setCode(department.getCode());
        return departmentRepository.save(depDb);
    }
}
