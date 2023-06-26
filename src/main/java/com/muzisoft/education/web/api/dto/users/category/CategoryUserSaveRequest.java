package com.muzisoft.education.web.api.dto.users.category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryUserSaveRequest {

    private String cateType;
    private String searchType;
    private String keyword;

}
