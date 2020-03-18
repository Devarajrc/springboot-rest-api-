package com.cts.emp.empapplication.daos;

import com.cts.emp.empapplication.entities.Employee;
import com.cts.emp.empapplication.responses.Response;

public interface EmployeeDao {

	public Response saveAppointment(Employee appointment); 
		
	

}
