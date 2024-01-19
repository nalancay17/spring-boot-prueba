package com.nico.springbootprueba.repository;

import com.nico.springbootprueba.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByName(String name);

    int countByName(String name);
}
