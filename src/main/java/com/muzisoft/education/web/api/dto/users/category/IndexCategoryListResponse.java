package com.muzisoft.education.web.api.dto.users.category;

import com.muzisoft.education.domain.category.CategoryEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexCategoryListResponse {

    private List<Theme> theme;
    private List<Area> area;
    private List<Type> type;
    private List<Target> target;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Theme{
        private String cateSeq;
        private String cateName;
        private String cateType;
        private String beforeImg;
        private String afterImg;

        public Theme(CategoryEntity category, String beforeImg, String afterImg) {
            this.cateSeq=category.getCateSeq();
            this.cateName=category.getCateName();
            this.cateType=category.getCateType();
            this.beforeImg=beforeImg;
            this.afterImg=afterImg;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Area{
        private String cateSeq;
        private String cateName;
        private String cateType;

        public Area(CategoryEntity category) {
            this.cateSeq=category.getCateSeq();
            this.cateName=category.getCateName();
            this.cateType=category.getCateType();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Type{
        private String cateSeq;
        private String cateName;
        private String cateType;

        public Type(CategoryEntity category) {
            this.cateSeq=category.getCateSeq();
            this.cateName=category.getCateName();
            this.cateType=category.getCateType();
        }
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Target{
        private String cateSeq;
        private String cateName;
        private String cateType;

        public Target(CategoryEntity category) {
            this.cateSeq=category.getCateSeq();
            this.cateName=category.getCateName();
            this.cateType=category.getCateType();
        }
    }

}
