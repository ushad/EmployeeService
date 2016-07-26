package com.employee.dao;

import java.util.List;

import com.employee.entity.Employee;


public interface EmployeeDao {
	
	public List<Employee> getAllEmployess() throws Exception;
	public Employee getEmployeeById(Long empId)throws Exception;
	public Employee updateEmployee(Employee employee)throws Exception;
	public void deleteEmployee(Long employeeId)throws Exception;
	public Employee createEmployee(Employee employee)throws Exception;
	public List<Employee> getunEmployed() throws Exception;
	public List<Employee> getAllEmployeesbyPage(Long pageNumber) throws Exception;




}
