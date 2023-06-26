package com.muzisoft.education.web.api.dto.users.categoryInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryInfoListRequest {

    private String searchType;
    private String cateType;
    private List<String> cateName;
    private String keyword;
}
