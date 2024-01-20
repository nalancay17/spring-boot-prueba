package com.nico.springbootprueba.service;

import com.nico.springbootprueba.entity.Department;
import com.nico.springbootprueba.error.DepartmentNameExistsException;
import com.nico.springbootprueba.error.DepartmentNotFoundException;
import com.nico.springbootprueba.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department save(Department department) throws DepartmentNameExistsException {
        departmentNameNotExistsVerification(department.getName());
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int id) throws DepartmentNotFoundException {
        return departmentRepository.findById(id).orElseThrow(() ->
                new DepartmentNotFoundException("Department not available")
        );
    }

    @Override
    public void deleteDepartmentById(int id) throws DepartmentNotFoundException {
        if (departmentRepository.existsById(id))
            departmentRepository.deleteById(id);
        throw new DepartmentNotFoundException("Department not available");
    }

    @Override
    public Department updateDepartment(int id, Department department) throws DepartmentNotFoundException, DepartmentNameExistsException {
        Department depDb = getDepartmentById(id);
        if (department.getName() != null && !department.getName().isEmpty()) {
            departmentNameNotExistsVerification(department.getName());
            depDb.setName(department.getName());
        }
        if (department.getAddress() != null && !department.getAddress().isEmpty())
            depDb.setAddress(department.getAddress());
        if (department.getCode() != null && !department.getCode().isEmpty())
            depDb.setCode(department.getCode());
        return departmentRepository.save(depDb);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    private boolean departmentNameExists(String name) {
        return departmentRepository.countByName(name) > 0;
    }

    private void departmentNameNotExistsVerification(String name) throws DepartmentNameExistsException {
        if (departmentNameExists(name))
            throw new DepartmentNameExistsException("The department name already exists");
    }
}
