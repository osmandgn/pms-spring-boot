package com.enoca.pms.mapper;

import com.enoca.pms.dto.EmployeeDTO;
import com.enoca.pms.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    List<EmployeeDTO> employeesToDTOs(List<Employee> employees);


}
