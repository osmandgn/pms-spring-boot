package com.enoca.pms.controller;

import com.enoca.pms.dto.CompanyDTO;
import com.enoca.pms.dto.request.CompanyRequest;
import com.enoca.pms.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies(){
        List<CompanyDTO> allCompanies = companyService.getAllCompanies();
        return ResponseEntity.ok(allCompanies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id){
        CompanyDTO company = companyService.getCompany(id);
        return ResponseEntity.ok(company);
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<CompanyDTO>> getAllPageable(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sort") String prop,
            @RequestParam(value = "direction",
                          required = false,
                          defaultValue = "DESC")Sort.Direction direction
            ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<CompanyDTO> companyPages = companyService.getAllPageable(pageable);
        return ResponseEntity.ok(companyPages);
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@Valid @RequestBody CompanyRequest companyRequest){
        CompanyDTO companyDTO = companyService.createCompany(companyRequest);
        return new ResponseEntity<>(companyDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id,
                                                    @Valid @RequestBody CompanyRequest companyUpdateRequest){
        CompanyDTO companyDTO = companyService.updateCompany(id, companyUpdateRequest);
        return ResponseEntity.ok(companyDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyDTO> deleteCompany(@PathVariable Long id){
               CompanyDTO companyDTO = companyService.deleteById(id);
        return ResponseEntity.ok(companyDTO);
    }










}
