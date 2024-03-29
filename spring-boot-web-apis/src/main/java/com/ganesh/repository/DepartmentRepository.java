package com.ganesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
