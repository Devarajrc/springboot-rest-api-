package com.cts.emp.empapplication.daos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.emp.empapplication.constants.StatusCode;
import com.cts.emp.empapplication.entities.Employee;
import com.cts.emp.empapplication.responses.Response;
import com.cts.emp.empapplication.utils.CommonUtils;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Response saveAppointment(Employee employee) {
		Response response = CommonUtils.getResponseObject("Add appointment data");
		try {
			String sql = "INSERT INTO employee (id,email,ph,address) VALUES(?,?,?,?)";
			int res = jdbcTemplate.update(sql, new Object[] { employee.getId(), employee.getEmail(),employee.getPh(), employee.getAddress() });

			if (res == 1) {
				response.setStatus(StatusCode.SUCCESS.name());
			} else {
				response.setStatus(StatusCode.ERROR.name());
			}
		} catch (Exception e) {
			logger.error("Exception in saveAppointment", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setError(e.getMessage());
		}
		return response;

	}

}
