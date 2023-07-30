package com.enoca.pms.controller;

import com.enoca.pms.dto.CompanyDTO;
import com.enoca.pms.dto.EmployeeDTO;
import com.enoca.pms.dto.request.CompanyUpdateRequest;
import com.enoca.pms.model.Company;
import com.enoca.pms.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        EmployeeDTO employee = employeeService.getEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<EmployeeDTO>> getAllPageable(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sort") String prop,
            @RequestParam(value = "direction",
                    required = false,
                    defaultValue = "DESC") Sort.Direction direction
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<EmployeeDTO> employeePages = employeeService.getAllPageable(pageable);
        return ResponseEntity.ok(employeePages);
    }
//
//    @PostMapping
//    public ResponseEntity<EmployeeDTO> createCompany(@Valid @RequestBody Company company){
//        CompanyDTO companyDTO = companyService.createCompany(company);
//        return new ResponseEntity<>(companyDTO, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<EmployeeDTO> updateCompany(@PathVariable Long id,
//                                                    @Valid @RequestBody CompanyUpdateRequest companyUpdateRequest){
//        CompanyDTO companyDTO = companyService.updateCompany(id, companyUpdateRequest);
//        return ResponseEntity.ok(companyDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<EmployeeDTO> deleteCompany(@PathVariable Long id){
//        CompanyDTO companyDTO = companyService.deleteById(id);
//        return ResponseEntity.ok(companyDTO);
//    }


}
