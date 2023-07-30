package com.enoca.pms.service;

import com.enoca.pms.dto.EmployeeDTO;
import com.enoca.pms.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
    }

    public EmployeeDTO getEmployee(Long id) {
    }

    public Page<EmployeeDTO> getAllPageable(Pageable pageable) {
    }
}
