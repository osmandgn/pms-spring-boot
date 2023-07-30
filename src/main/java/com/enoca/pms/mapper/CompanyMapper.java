package com.enoca.pms.mapper;

import com.enoca.pms.dto.CompanyDTO;
import com.enoca.pms.dto.request.CompanyRequest;
import com.enoca.pms.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDTO companyToCompanyDTO (Company company);

    List<CompanyDTO> companiesToDTOs (List<Company> companies);

    @Mapping(target="id", ignore = true)
    Company CompanyDtoToCompany(CompanyRequest companyRequest);
}
