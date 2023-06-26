package com.muzisoft.education.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String>, CategoryQueryRepository {

    CategoryEntity findByCateName(String cateName);
    CategoryEntity findByCateTypeAndCateName(String cateType, String cateName);

}