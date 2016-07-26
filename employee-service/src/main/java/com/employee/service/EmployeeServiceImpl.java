package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee createEmployee(Employee employee) throws Exception {
		return employeeDao.createEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) throws Exception {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		return employeeDao.getAllEmployess();
	}

	@Override
	public void deleteEmployee(Long id) throws Exception {
		employeeDao.deleteEmployee(id);

	}
	
	@Override
	public List<Employee> getunEmployed() throws Exception{
		return employeeDao.getunEmployed();
	}

	@Override
	public List<Employee> getEmployeesPageNo(Long id) throws Exception {
		return employeeDao.getAllEmployeesbyPage(id);
	}
	}



