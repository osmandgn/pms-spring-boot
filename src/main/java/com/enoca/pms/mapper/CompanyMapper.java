package com.enoca.pms.mapper;

import com.enoca.pms.dto.CompanyDTO;
import com.enoca.pms.model.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDTO companyToCompanyDTO (Company company);

    List<CompanyDTO> companiesToDTOs (List<Company> companies);
}
