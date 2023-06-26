package com.muzisoft.education.web.service.category;

import com.muzisoft.education.domain.category.CategoryEntity;
import com.muzisoft.education.domain.category.CategoryRepository;
import com.muzisoft.education.domain.categoryInfo.CategoryInfoEntity;
import com.muzisoft.education.domain.categoryInfo.CategoryInfoRepository;
import com.muzisoft.education.domain.company.CompanyEntity;
import com.muzisoft.education.domain.company.CompanyRepository;
import com.muzisoft.education.domain.file.EFileManager;
import com.muzisoft.education.domain.file.FileManagerRepository;
import com.muzisoft.education.domain.program.ProgramEntity;
import com.muzisoft.education.domain.program.ProgramRepository;
import com.muzisoft.education.utils.handler.FileHandler;
import com.muzisoft.education.web.api.dto.admin.category.CategoryDetailResponse;
import com.muzisoft.education.web.api.dto.admin.category.CategoryListResponse;
import com.muzisoft.education.web.api.dto.admin.category.CategorySaveRequest;
import com.muzisoft.education.web.api.dto.admin.category.CategoryUpdateRequest;
import com.muzisoft.education.web.api.dto.users.category.CategoryUserListResponse;
import com.muzisoft.education.web.api.dto.users.category.CategoryUserSaveRequest;
import com.muzisoft.education.web.api.dto.users.category.IndexCategoryListResponse;
import com.muzisoft.education.web.api.dto.users.categoryInfo.CategoryInfoListRequest;
import com.muzisoft.education.web.api.dto.users.categoryInfo.CategoryInfoProgramResponse;
import com.muzisoft.education.web.exception.business.CEntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryInfoRepository categoryInfoRepository;
    private final ProgramRepository programRepository;
    private final CompanyRepository companyRepository;
    private final FileManagerRepository fileManagerRepository;
    private final FileHandler fileHandler;

    /** admin: 카테고리 신규등록 **/
    @Transactional
    public void categoryInsert(CategorySaveRequest request) {

        CategoryEntity categoryName = categoryRepository.findByCateName(request.getCateName());

        if(categoryName!=null) {
//            System.out.println(">>>"+ categoryName);
            throw new RuntimeException("카테고리가 중복되었습니다.");
        }else {
            CategoryEntity category = categoryRepository.save(
                    CategoryEntity.builder()
                            .cateName(request.getCateName())
                            .cateType(request.getCateType())
                            .script(request.getScript())
                            .build()
            );
            if(request.getBeforeImg()!=null && !request.getBeforeImg().isEmpty()) {
                List<MultipartFile> beforeImages = new ArrayList<>();
                beforeImages.add(request.getBeforeImg());
                EFileManager beforeImg = fileManagerRepository.save(fileHandler.parse(beforeImages, "theme-img").get(0));
                category.updateBeforeImg(beforeImg);
            }
            if(request.getAfterImg()!=null && !request.getAfterImg().isEmpty()) {
                List<MultipartFile> afterImages = new ArrayList<>();
                afterImages.add(request.getAfterImg());
                EFileManager afterImg = fileManagerRepository.save(fileHandler.parse(afterImages, "theme-img").get(0));
                category.updateAfterImg(afterImg);
            }
        }
    }

    /** admin: 카테고리 목록조회 **/
    @Transactional
    public Page<CategoryListResponse> categoryList(String cateType, Pageable pageable) {
        Page<CategoryListResponse> result = categoryRepository.categoryList(cateType, pageable);

//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//
//        int rowNum = (pageSize * pageNumber) + 1;

        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        int totalCount = (int) result.getTotalElements();

        int dec = pageSize * pageNumber;
        for(CategoryListResponse response : result) {
//            response.setRowNum(rowNum);
//            rowNum++;
            response.setRowNum(totalCount-dec);
            dec++;
        }

        return result;
    }

    /** admin: 카테고리 상세조회 **/
    @Transactional
    public CategoryDetailResponse categoryDetail(String cateSeq, HttpServletRequest request) {
        CategoryEntity category = categoryRepository.findById(cateSeq).orElseThrow(CEntityNotFoundException.CCategoryNotFoundException::new);

        String beforeImg=null;
        String afterImg=null;
        if(!ObjectUtils.isEmpty(category.getBeforeImg())) {
            beforeImg = fileHandler.fileUrl(category.getBeforeImg(), request);
        }
        if(!ObjectUtils.isEmpty(category.getAfterImg())) {
            afterImg = fileHandler.fileUrl(category.getAfterImg(), request);
        }
        return new CategoryDetailResponse(category, beforeImg, afterImg);
    }


    /** admin: 카테고리 수정 **/
    @Transactional
    public void categoryUpdate(CategoryUpdateRequest request) {

        // 카테고리 유효성 체크
        CategoryEntity category = categoryRepository.findById(request.getCateSeq()).orElseThrow(() -> new RuntimeException("카테고리 정보를 찾을 수 없습니다."));
        // 카테고리명 중복 체크
        CategoryEntity cate = categoryRepository.findByCateName(request.getCateName());

        // 카테고리가 중복이 아닐 때
        if (cate == null || request.getCateName().equals(category.getCateName())) {

            if (request.getCateName() != null && !request.getCateName().equals("")) {
                category.updateCateName(request.getCateName());
            }
            if (request.getCateType() != null && !request.getCateType().equals("")) {
                category.updateCateType(request.getCateType());
            }
            if (request.getScript() != null) {
                category.updateCateScript(request.getScript());
            }

            if(request.getAfterImg()!=null && !request.getAfterImg().isEmpty()) {
                List<MultipartFile> afterImgList = new ArrayList<>();
                afterImgList.add(request.getAfterImg());
                EFileManager afterImg = fileManagerRepository.save(fileHandler.parse(afterImgList, "theme-img").get(0));
                category.updateAfterImg(afterImg);
            }
            if(request.getBeforeImg()!=null && !request.getBeforeImg().isEmpty()) {
                List<MultipartFile> beforeImages = new ArrayList<>();
                beforeImages.add(request.getBeforeImg());
                EFileManager beforeImg = fileManagerRepository.save(fileHandler.parse(beforeImages, "theme-img").get(0));
                category.updateBeforeImg(beforeImg);
            }
        // 카티고리가 중복일 때
        }else {
            throw new RuntimeException("카테고리가 중복되었습니다.");
        }
    }

    /** admin: 카테고리 삭제 **/
    @Transactional
    public void categoryDelete(List<String> cateSeq) {
        for (String seq : cateSeq) {
            CategoryEntity category = categoryRepository.findById(seq).orElseThrow(() -> new RuntimeException("카테고리 정보를 찾을 수 없습니다."));;
            String categorySeq = category.getCateSeq();

            // 카테고리와 연결된 프로그램 리스트
            List<ProgramEntity> programList = programRepository.findByCategoryAndWithdrawal(categorySeq);
            if(programList.size()!=0 && programList!=null){
                for(ProgramEntity program : programList){

                    // 카테고리와 연결된 프로그램이 있는 categoryInfo 테이블 record 값 삭제
                    List<CategoryInfoEntity> categoryInfoList = categoryInfoRepository.findByProgram(program);
                    for(CategoryInfoEntity categoryInfo: categoryInfoList) {
                        categoryInfoRepository.delete(categoryInfo);
                    }

                    // categoryInfo 삭제 후 program 삭제 처리 (실제로 테이블 record를 지우지 않고, withdrawal값만 1로 변경
                    program.deleteProgram();
                }
            }
            categoryRepository.delete(category);
        }
    }

    /** user: 카테고리 목록조회 **/
    @Transactional
    public Page<CategoryInfoProgramResponse> userSearchResultList(CategoryInfoListRequest request, Pageable pageable, HttpServletRequest httpServletRequest) {
        Page<CategoryInfoProgramResponse> result = categoryInfoRepository.userSearchResultList(request, pageable);

        for(CategoryInfoProgramResponse response : result.getContent()) {
            String[] targetList = response.getTarget().split("\\|");
            String target = "";
            for(int i=0; i<targetList.length; i++) {
                String strTarget = categoryRepository.findById(targetList[i]).get().getCateName();
                if(i==0) {
                    target += strTarget;
                }else {
                    target += ", " + strTarget;
                }
            }
            response.setTarget(target);

            String[] typeList = response.getType().split("\\|");
            String type = "";
            for(int i=0; i<typeList.length; i++) {
                String strType = categoryRepository.findById(typeList[i]).get().getCateName();
                if(i==0) {
                    type += strType;
                }else {
                    type += " ," + strType;
                }
            }
            response.setType(type);

            String[] themeList = response.getTheme().split("\\|");
            String theme = "";
            for(int i=0; i<themeList.length; i++) {
                String strTheme = categoryRepository.findById(themeList[i]).get().getCateName();
                if(i==0) {
                    theme += strTheme;
                }else {
                    theme += " ," + strTheme;
                }
            }
            response.setTheme(theme);

            ProgramEntity program = programRepository.findById(response.getProgramSeq()).orElseThrow(CEntityNotFoundException.CProgramNotFoundException::new);
            CompanyEntity company = companyRepository.findById(response.getCompanySeq()).orElseThrow(CEntityNotFoundException.CCompanyNotFoundException::new);

            String programImg=null;
            String companyImg=null;
            if(!ObjectUtils.isEmpty(program.getImg1())) {
                programImg = fileHandler.fileUrl(program.getImg1(), httpServletRequest);
            }
            if(!ObjectUtils.isEmpty(company.getImg())) {
                companyImg = fileHandler.fileUrl(company.getImg(), httpServletRequest);
            }
            response.setProgramImg(programImg);
            response.setCompanyImg(companyImg);
        }
        return result;
    }


    /** user: 인덱스(모달) 용 카테고리 리스트 **/
    @Transactional
    public IndexCategoryListResponse indexCategoryList(HttpServletRequest httpServletRequest) {
        IndexCategoryListResponse response = new IndexCategoryListResponse();
        List<IndexCategoryListResponse.Theme> themes = new ArrayList<>();
        List<IndexCategoryListResponse.Target> targets = new ArrayList<>();
        List<IndexCategoryListResponse.Area> areas = new ArrayList<>();
        List<IndexCategoryListResponse.Type> types = new ArrayList<>();

        List<CategoryEntity> categories = categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "cateName"));
        for(CategoryEntity category : categories) {
//            System.out.println(">>>"+category.getCateType());
            switch (category.getCateType()) {
                case "교육대상":
                    IndexCategoryListResponse.Target target= new IndexCategoryListResponse.Target(category);
                    targets.add(target);
                    break;
                case "지역":
                    IndexCategoryListResponse.Area area= new IndexCategoryListResponse.Area(category);
                    areas.add(area);
                    break;
                case "교육테마":
                    String beforeImg=null;
                    String afterImg=null;
                    if(!ObjectUtils.isEmpty(category.getBeforeImg())) {
                        beforeImg = fileHandler.fileUrl(category.getBeforeImg(), httpServletRequest);
                    }
                    if(!ObjectUtils.isEmpty(category.getAfterImg())) {
                        afterImg = fileHandler.fileUrl(category.getAfterImg(), httpServletRequest);
                    }
                    IndexCategoryListResponse.Theme theme= new IndexCategoryListResponse.Theme(category, beforeImg, afterImg);
                    themes.add(theme);
                    break;
                case "교육유형":
                    IndexCategoryListResponse.Type type= new IndexCategoryListResponse.Type(category);
                    types.add(type);
                    break;
                }
            }

        response.setArea(areas);
        response.setTarget(targets);
        response.setTheme(themes);
        response.setType(types);

        return response;
    }


}
