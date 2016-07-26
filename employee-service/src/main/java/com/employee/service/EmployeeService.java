package com.employee.service;

import java.util.List;
import com.employee.entity.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee ) throws Exception;
	public Employee updateEmployee(Employee employee) throws Exception;
	public Employee getEmployeeById(Long id) throws Exception;
	public List<Employee> getAllEmployees() throws Exception;
	public void deleteEmployee(Long id) throws Exception;
	public List<Employee> getunEmployed() throws Exception;
	public List<Employee> getEmployeesPageNo(Long id) throws Exception;

	

}
