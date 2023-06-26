package com.muzisoft.education.domain.program;

import com.muzisoft.education.domain.company.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, String>, ProgramQueryRepository {

    ProgramEntity findByTitle(String title);

    List<ProgramEntity> findByCompany(CompanyEntity company);
    List<ProgramEntity> findByCompanyAndWithdrawal(CompanyEntity company, boolean withdrawal);
}