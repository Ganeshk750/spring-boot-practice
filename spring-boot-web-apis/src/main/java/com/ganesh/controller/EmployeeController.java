package com.ganesh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ganesh.model.Employee;
import com.ganesh.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/emp/v1")
@RequiredArgsConstructor
public class EmployeeController {
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	private final EmployeeRepository employeeRepo;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addNewDepartment(@RequestBody Employee emp) {
		Employee newEmp = employeeRepo.save(emp);
		return new ResponseEntity<Employee>(newEmp, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee emp){
		Employee uptadedEmployee = null;
		Optional<Employee> getEmployee = employeeRepo.findById(id);
		if(getEmployee.isPresent()) {
			Employee employee = getEmployee.get();
			employee.setEmployeename(emp.getEmployeename());
			employee.setDepartment(emp.getDepartment());
			employee.setDateofjoining(emp.getDateofjoining());
			employee.setPhotofilename(emp.getPhotofilename());
			uptadedEmployee = employeeRepo.save(employee);
		}else {
			throw new RuntimeException("No Employee Found with this id: "+ id);
		}
		return new ResponseEntity<Employee>(uptadedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		Optional<Employee> getEmployee = employeeRepo.findById(id);
		if(getEmployee.isPresent()) {
			employeeRepo.deleteById(id);
		}else {
			throw new RuntimeException("No Employee Found with this id: "+ id);
		}
		
		return "Employee Deleted Successfully.";
	}

	
	@PostMapping("/saveimage")
	public ResponseEntity<Object> photoUpolad(@RequestParam("File") MultipartFile file) throws IOException{
		File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
		myFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();
		return new ResponseEntity<Object>("The Photo Uploaded Successfully", HttpStatus.OK);
	}

}
