package com.cts.emp.empapplication.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.emp.empapplication.constants.*;
import com.cts.emp.empapplication.entities.Employee;
import com.cts.emp.empapplication.responses.CustomErrorDetails;
import com.cts.emp.empapplication.responses.Response;
import com.cts.emp.empapplication.services.EmployeeService;
import com.cts.emp.empapplication.utils.CommonUtils;

@RestController
@RequestMapping(Constants.CONTEXTPATH)
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value=Constants.CREATEEMPLOYEE,produces="application/json")
	public Response saveEmployee(@RequestBody Employee employee, HttpServletRequest request,HttpServletResponse response) {
		
		logger.info("saveAppointment: Received request URL: " + request.getRequestURL().toString()+ ((request.getQueryString() == null) ? "" : "?" + 
					request.getQueryString().toString()));
		logger.info("saveAppointment: Received request: " + CommonUtils.getJson(employee));
		return employeeService.saveEmployee(employee);
	}
	
	
	
	@GetMapping(value = Constants.GETEMPLOYEE,  produces = "application/json")
	public @ResponseBody String getEmployees(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("getEmployees: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<Employee> employees = employeeService.getEmployees();
		Response res = CommonUtils.getResponseObject("List of Employees");
		if (employees == null) {
			CustomErrorDetails err = CommonUtils.getErrorResponse("Employees Not Found", "Employees Not Found");
			res.setError(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(employees);
		}
		logger.info("getEmployee: Sent response");
		return CommonUtils.getJson(res);
	}
	
	
	@PutMapping(value =Constants.UPDATEeMPLOYEE, produces = "application/json")
	public Response updateAppointment(@RequestBody Employee employee, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("updateAppointment: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateAppointment: Received request: " + CommonUtils.getJson(employee));
		return employeeService.updateAppointment(employee);
	}
	

}
