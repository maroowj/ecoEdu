package com.muzisoft.education.domain.categoryInfo;

import com.muzisoft.education.domain.program.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryInfoRepository extends JpaRepository<CategoryInfoEntity, String>, CategoryInfoQueryRepository {
    List<CategoryInfoEntity> findByProgram(ProgramEntity program);

}