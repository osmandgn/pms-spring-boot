package com.enoca.pms.service;

import com.enoca.pms.dto.EmployeeDTO;
import com.enoca.pms.dto.request.EmployeeRequest;
import com.enoca.pms.exception.ConflictException;
import com.enoca.pms.exception.ResourceNotFoundException;
import com.enoca.pms.exception.message.ErrorMessage;
import com.enoca.pms.mapper.EmployeeMapper;
import com.enoca.pms.model.Company;
import com.enoca.pms.model.Employee;
import com.enoca.pms.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final CompanyService companyService;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, CompanyService companyService){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.companyService = companyService;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeMapper.employeesToDTOs(employeeRepository.findAll());
    }

    public EmployeeDTO getEmployee(Long id) {
       return employeeMapper.employeeToEmployeeDTO(getByID(id));
    }

    public Page<EmployeeDTO> getAllPageable(Pageable pageable) {
       Page<Employee> employeePages = employeeRepository.findAll(pageable);
      return employeePages.map(employeeMapper::employeeToEmployeeDTO);
    }

    public EmployeeDTO createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.EmployeeDtoTOEmployee(employeeRequest);
        employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeRequest employeeRequest) {
        Employee employee = getByID(id);
        if (!employee.getEmail().equals(employeeRequest.getEmail()) && employeeRepository.existsByEmail(employeeRequest.getEmail())){
            throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST_MESSAGE, employeeRequest.getEmail()));
        }
        employee.setEmail(employeeRequest.getEmail());
        employee.setSalary(employeeRequest.getSalary());
        employee.setJobTitle(employeeRequest.getJobTitle());
        employee.setFirsName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setPhoneNumber(employeeRequest.getPhoneNumber());

        Company company = companyService.getCompanyByName(employeeRequest.getCompanyName());
        employee.setCompany(company);
        employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    public EmployeeDTO deleteById(Long id) {
        Employee employee = getByID(id);
        employeeRepository.delete(employee);
        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    private Employee getByID(Long id){
       return employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessage.RESOURCE_NOT_FOUND_EXCEPTION, id)));
    }
}
