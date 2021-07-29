package com.ganesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.Department;
import com.ganesh.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dep/v1")
@RequiredArgsConstructor
public class DepartmentController {
	
	private final DepartmentRepository departmentRepo;
	
	@GetMapping("/department")
	public List<Department> getAllDepartment(){
		return departmentRepo.findAll();
	}
	
	@PostMapping("/department")
	public ResponseEntity<Department> addNewDepartment(@RequestBody Department dept) {
		Department newDept = departmentRepo.save(dept);
		return new ResponseEntity<Department>(newDept, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") int id, @RequestBody Department dept){
		Department uptadedDepartment = null;
		Optional<Department> getDepartment = departmentRepo.findById(id);
		if(getDepartment.isPresent()) {
			Department department = getDepartment.get();
			department.setDepartmentname(dept.getDepartmentname());
			uptadedDepartment = departmentRepo.save(department);
		}else {
			throw new RuntimeException("No Department Found with this id: "+ id);
		}
		return new ResponseEntity<Department>(uptadedDepartment, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable("id") int id) {
		Optional<Department> getDepartment = departmentRepo.findById(id);
		if(getDepartment.isPresent()) {
			departmentRepo.deleteById(id);
		}else {
			throw new RuntimeException("No Department Found with this id: "+ id);
		}
		
		return "Department Deleted Successfully.";
	}

}
