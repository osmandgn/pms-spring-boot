package com.enoca.pms.mapper;

import com.enoca.pms.dto.EmployeeDTO;
import com.enoca.pms.dto.request.EmployeeRequest;
import com.enoca.pms.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    List<EmployeeDTO> employeesToDTOs(List<Employee> employees);

    @Mapping(target = "id", ignore = true)
    Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);


}
