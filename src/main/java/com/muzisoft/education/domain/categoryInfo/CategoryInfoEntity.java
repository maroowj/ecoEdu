package com.muzisoft.education.domain.categoryInfo;


import com.muzisoft.education.domain.category.CategoryEntity;
import com.muzisoft.education.domain.program.ProgramEntity;
import com.muzisoft.education.utils.manager.SeqManager;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "categoryInfo"
//        , uniqueConstraints={
//                @UniqueConstraint(
//                        name= "programCate" ,
//                        columnNames={"programSeq", "categorySeq"}
//                )
//        }
)
@DynamicInsert
@DynamicUpdate
@Entity
@ToString
public class CategoryInfoEntity {

    // strategy 수정 후 사용

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_manager_category_info")
    @GenericGenerator(name = "seq_manager_category_info", strategy = "com.muzisoft.education.utils.manager.SeqManager", parameters = {
            @org.hibernate.annotations.Parameter(name = SeqManager.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_USER_SEQ_PARAMETER, value = "ctif_"),
            @org.hibernate.annotations.Parameter(name = SeqManager.NUMBER_FORMAT_PARAMETER, value = "%010d"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_COLUMN_PARAM, value = "seq")
    })
    @Column(nullable = false, updatable = false, length = 15)
    @Id
    private String cateInfoSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programSeq")
    private ProgramEntity program;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorySeq")
    private CategoryEntity category;

    @Builder
    public CategoryInfoEntity(ProgramEntity program, CategoryEntity category) {
        this.program = program;
        this.category = category;
    }

    public void updateCategory(CategoryEntity category) {
        this.category = category;
    }
}
