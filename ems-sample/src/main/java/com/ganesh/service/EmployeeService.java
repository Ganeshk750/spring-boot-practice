package com.ganesh.service;


import com.ganesh.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @created: 11/09/2021 - 11:40 AM
 * @author: Ganesh
 */

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
