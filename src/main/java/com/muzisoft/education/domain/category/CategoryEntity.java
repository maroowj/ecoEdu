package com.muzisoft.education.domain.category;


import com.muzisoft.education.domain.base.BaseTimeEntity;
import com.muzisoft.education.domain.file.EFileManager;
import com.muzisoft.education.utils.FileManagerUtils;
import com.muzisoft.education.utils.manager.SeqManager;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "category"
        , uniqueConstraints={
                @UniqueConstraint(
                        name= "Cate" ,
                        columnNames={"cateName", "cateType"}
                )
        }
        )
@DynamicInsert
@DynamicUpdate
@Entity
public class CategoryEntity extends BaseTimeEntity {

    // strategy 수정 후 사용

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_manager_category")
    @GenericGenerator(name = "seq_manager_category", strategy = "com.muzisoft.education.utils.manager.SeqManager", parameters = {
            @org.hibernate.annotations.Parameter(name = SeqManager.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_USER_SEQ_PARAMETER, value = "cate_"),
            @org.hibernate.annotations.Parameter(name = SeqManager.NUMBER_FORMAT_PARAMETER, value = "%010d"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_COLUMN_PARAM, value = "seq")
    })
    @Column(nullable = false, updatable = false, length = 15)
    @Id
    private String cateSeq;

    @Column(nullable = false, length = 200)
    private String cateName;

    @Column(nullable = false, length = 200)
    private String cateType;

    @Column(columnDefinition = "TEXT")
    private String script;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "beforeImg")
    private EFileManager beforeImg;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "afterImg")
    private EFileManager afterImg;

    @Builder
    public CategoryEntity(String cateName, String cateType, String script) {
        this.cateName = cateName;
        this.cateType = cateType;
        this.script = script;
    }

    public void updateCateScript(String script) {
        this.script = script;
    }

    public void updateCateName(String cateName) {
        this.cateName = cateName;
    }

    public void updateCateType(String cateType) {
        this.cateType = cateType;
    }


    public void updateBeforeImg(EFileManager beforeImg) {
//        if(getBeforeImg()!=null) {
//            FileManagerUtils.delete(getBeforeImg());
//        }
        this.beforeImg = beforeImg;
    }

    public void updateAfterImg(EFileManager afterImg) {
//        if(getAfterImg()!=null) {
//            FileManagerUtils.delete(afterImg);
//        }
        this.afterImg = afterImg;
    }
}
