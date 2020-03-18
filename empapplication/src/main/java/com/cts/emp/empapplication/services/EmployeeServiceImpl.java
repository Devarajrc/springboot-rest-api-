package com.cts.emp.empapplication.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.emp.empapplication.controllers.EmployeeController;
import com.cts.emp.empapplication.daos.EmployeeDao;
import com.cts.emp.empapplication.entities.Employee;
import com.cts.emp.empapplication.responses.Response;
import com.cts.emp.empapplication.utils.CommonUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Response saveEmployee(Employee employee) {
		try {
			Employee appointment = new Employee();
			/*
			 * BeanUtils.copyProperties(appointmentModel, appointment);
			 * appointment.setAppointmentId(CommonUtils.generateRandomId());
			 * appointment.setIsActive(true);
			 */
			Response response = employeeDao.saveAppointment(appointment);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateAppointment(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
