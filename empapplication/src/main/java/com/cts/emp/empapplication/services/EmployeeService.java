package com.cts.emp.empapplication.services;

import java.util.List;

import com.cts.emp.empapplication.entities.Employee;
import com.cts.emp.empapplication.responses.Response;

public interface EmployeeService {

	public Response saveEmployee(Employee employee);

	public List<Employee> getEmployees();

	public Response updateAppointment(Employee employee);
		
	

}
