package com.enoca.pms.service;

import com.enoca.pms.dto.CompanyDTO;
import com.enoca.pms.dto.request.CompanyRequest;
import com.enoca.pms.exception.ConflictException;
import com.enoca.pms.exception.ResourceNotFoundException;
import com.enoca.pms.exception.message.ErrorMessage;
import com.enoca.pms.mapper.CompanyMapper;
import com.enoca.pms.model.Company;
import com.enoca.pms.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper){
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public List<CompanyDTO> getAllCompanies() {
      List<Company> companies = companyRepository.findAll();
      List<CompanyDTO> companyDTOs = companyMapper.companiesToDTOs(companies);
      return companyDTOs;
    }


    public CompanyDTO getCompany(Long id) {
        Company company = getCompanyByID(id);
        return companyMapper.companyToCompanyDTO(company);
    }

    public CompanyDTO createCompany(CompanyRequest companyRequest) {
        Company company = companyMapper.CompanyDtoToCompany(companyRequest);
        companyRepository.save(company);
        return companyMapper.companyToCompanyDTO(company);
    }

    private Company getCompanyByID(Long id){
        return companyRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessage.RESOURCE_NOT_FOUND_EXCEPTION, id))
                );
    }

    public Page<CompanyDTO> getAllPageable(Pageable pageable) {
        Page<Company> companyPages = companyRepository.findAll(pageable);
        return companyPages.map(company -> companyMapper.companyToCompanyDTO(company));
    }


    public CompanyDTO updateCompany(Long id, CompanyRequest companyUpdateRequest) {
        Company existCompany = getCompanyByID(id);
        if (!existCompany.getEmail().equals(companyUpdateRequest.getEmail()) && companyRepository.existsByEmail(companyUpdateRequest.getEmail())){
            throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST_MESSAGE, companyUpdateRequest.getEmail()));
        }
        existCompany.setName(companyUpdateRequest.getName());
        existCompany.setEmail(companyUpdateRequest.getEmail());
        existCompany.setAddress(companyUpdateRequest.getAddress());
        existCompany.setIndustry(companyUpdateRequest.getIndustry());
        existCompany.setWebsite(companyUpdateRequest.getWebsite());

        return companyMapper.companyToCompanyDTO(companyRepository.save(existCompany));
    }

    public CompanyDTO deleteById(Long id) {
       Company company = getCompanyByID(id);
       companyRepository.delete(company);
       return companyMapper.companyToCompanyDTO(company);
    }
}
