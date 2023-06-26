package com.muzisoft.education.web.api.dto.admin.category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategorySaveRequest {

    MultipartFile beforeImg;
    MultipartFile afterImg;

    private String cateName;
    private String cateType;
    private String script;
    private int etc;
}
