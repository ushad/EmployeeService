package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService; 



@Controller
@Api(value = "All operations involving employees", tags = "Employees")
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	private final String INTERNAL_SERVER_ERROR = "Data store not configured or unreachable";
	private final String NOT_FOUND = "Employee not found";

	
	@RequestMapping(value = { "/v1/employees", "/v1/employees" }, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get all Employess", notes = "Lists all Employess")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returned employess"),
			@ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR) })
	@ResponseStatus(value = HttpStatus.OK)
	public List<Employee> getAllEmployess( HttpServletResponse response)
			throws Exception {
		return employeeService.getAllEmployees();
	}
	@RequestMapping(value = { "v1/employees", "/v1/employees" }, method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Add a Employee", notes = "Add a new Employee")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created employee"),
			@ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR) })
	public Employee createEmployee(@RequestBody Employee employee,
			HttpServletResponse response) throws Exception {
		
		if(!isUserBlank(employee)){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return employee;

 		}
		else
		{
		response.setStatus(HttpServletResponse.SC_CREATED);
		return employeeService.createEmployee(employee);
		}
	}
	
	@RequestMapping(value = { "/v1/employees/{emp_id}", "/v1/employees/{emp_id}" }, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get a Employee by id", notes = "Get a particular Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returned a Employee"),
			 @ApiResponse(code = 404, message = NOT_FOUND),
			@ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR) })
	@ResponseStatus(value = HttpStatus.OK)
	public Employee getEmployeeById(@PathVariable(value = "emp_id") Long id,
			 HttpServletResponse response) throws Exception {
		return employeeService.getEmployeeById(id);
	}

	@RequestMapping(value = { "/v1/employees/", "/v1/employees/" }, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get a list of unemployed Employees", notes = "List unemployed Employees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returned a Employee"),
			 @ApiResponse(code = 404, message = NOT_FOUND),
			@ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR) })
	@ResponseStatus(value = HttpStatus.OK)
	public List<Employee> getUnEmployeed(
			 HttpServletResponse response) throws Exception {
		return employeeService.getunEmployed();
	}
	
	@RequestMapping(value = { "/v1/employees/{emp_id}", "/v1/employees/{emp_id}" }, method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "Updates a Employee", notes = "Update an existing Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated a Employee", response = Employee.class),
			 @ApiResponse(code = 404, message = NOT_FOUND),
			@ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR) })
	@ResponseStatus(value = HttpStatus.OK)
	public Employee updateEmployee(@PathVariable(value = "emp_id") Long id, @RequestBody Employee employee,
			 HttpServletResponse response) throws Exception {

		 return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value = { "/v1/employees/{emp_id}", "/v1/employees/{emp_id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "Delete a Employee", notes = "Delete an existing Employee")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully removed Employee"),
			@ApiResponse(code = 404, message = NOT_FOUND),
			@ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR) })
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable(value = "emp_id") Long id,
			 HttpServletResponse response) throws Exception {
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		employeeService.deleteEmployee(id);
	}

	@RequestMapping(value = { "/v1/employees/{page_id}/page", "/v1/employees/{page_id}/page" }, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get all Employees by PageNumber", notes = "Lists all Employess by PageNumber")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returned employess"),
			@ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR) })
	@ResponseStatus(value = HttpStatus.OK)
	public List<Employee> getAllEmployessbyPageNo(@PathVariable(value = "page_id") Long id, HttpServletResponse response)
			throws Exception {
		return employeeService.getEmployeesPageNo(id);
	}
	
	private boolean isUserBlank(Employee user){
		if((user.getEmail()!=null&&!user.getEmail().trim().isEmpty())&&(user.getName()!=null&&!user.getName().trim().isEmpty()))
 			return true;
		else
		return false;
	}
}
