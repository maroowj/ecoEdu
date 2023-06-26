package com.muzisoft.education.web.api.dto.admin.category;

import com.muzisoft.education.domain.category.CategoryEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryDetailResponse {

    private String cateSeq;
    private String cateName;
    private String cateType;
    private String script;
    private String beforeImg;
    private String afterImg;

    public CategoryDetailResponse(CategoryEntity category, String beforeImg, String afterImg) {
        this.cateSeq = category.getCateSeq();
        this.cateName = category.getCateName();
        this.cateType = category.getCateType();
        this.script = category.getScript();
        this.beforeImg = beforeImg;
        this.afterImg = afterImg;
    }
}
