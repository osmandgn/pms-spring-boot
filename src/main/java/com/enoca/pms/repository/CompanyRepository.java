package com.enoca.pms.repository;

import com.enoca.pms.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByEmail(String email);

    Optional<Company> findByName(String companyName);
}
