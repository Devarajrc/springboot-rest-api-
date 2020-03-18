package com.cts.emp.empapplication.mappers;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cts.emp.empapplication.dtos.EmployeeDto;
import com.cts.emp.empapplication.entities.Employee;

public interface EmployeeMapper {
	
	EmployeeMapper INSTANCE=Mappers.getMapper(EmployeeMapper.class);
	
	@Mappings({
		@Mapping(source="name",target="name"),
		@Mapping(source="email",target="email"),
		@Mapping(source="id",target="id"),
		@Mapping(source="ph",target="ph"),
		@Mapping(source="address",target="address")
	})
	EmployeeDto empToEmployeeDto(Employee emp);
	
	List<Employee> empToEmployeeDto(List<Employee> employees); 

}
