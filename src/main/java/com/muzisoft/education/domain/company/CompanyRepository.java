package com.muzisoft.education.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, String>, CompanyQueryRepository{

    CompanyEntity findByName(String name);

}