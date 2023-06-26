package com.muzisoft.education.web.service.company;

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
import com.muzisoft.education.web.api.dto.admin.company.CompanyDetailResponse;
import com.muzisoft.education.web.api.dto.admin.company.CompanyListResponse;
import com.muzisoft.education.web.api.dto.admin.company.CompanySaveRequest;
import com.muzisoft.education.web.api.dto.admin.company.CompanyUpdateRequest;
import com.muzisoft.education.web.api.dto.admin.program.ProgramDetailResponse;
import com.muzisoft.education.web.api.dto.users.UserCompanyDetailResponse;
import com.muzisoft.education.web.api.dto.users.UserProgramDetailResponse;
import com.muzisoft.education.web.exception.business.CEntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryInfoRepository categoryInfoRepository;
    private final ProgramRepository programRepository;
    private final FileManagerRepository fileManagerRepository;

    private final FileHandler fileHandler;

    // startDate 날짜 월만 입력 문제
    // 이미지 저장 문제
    /** 단체 신규등록 **/
    @Transactional
    public void companyInsert(CompanySaveRequest request) {
        System.out.println(request.getArea());

        if (request.getArea().equals("강화군") || request.getArea().equals("옹진군")) {
            request.setArea("강화·옹진군");
        }

        CategoryEntity category = categoryRepository.findByCateName(request.getArea());

        CompanyEntity companyName = companyRepository.findByName(request.getName());

        boolean type = false;
        if (request.getType() == 1) {
            type = true;
        }

        if (companyName == null) {
            CompanyEntity company = companyRepository.save(
                    CompanyEntity.builder()
                            .name(request.getName())
                            .script(request.getScript())
                            .startDate(request.getStartDate())
                            .createNo(request.getCreateNo())
                            .type(type)
                            .homeUrl(request.getHomeUrl())
                            .cafeUrl(request.getCafeUrl())
                            .email(request.getEmail())
                            .tel(request.getTel())
                            .category(category)
                            .addressDetail(request.getAddressDetail())
                            .build()
            );
            if (request.getImg() != null && !request.getImg().isEmpty()) {
                List<MultipartFile> images = new ArrayList<>();
                images.add(request.getImg());
                EFileManager img = fileManagerRepository.save(fileHandler.parse(images, "company-img").get(0));
                company.setImg(img);
            }
        }else {
            throw new RuntimeException("단체명이 중복되었습니다.");
        }
    }

    /** 단체 목록조회 **/
    @Transactional
    public Page<CompanyListResponse> companyList(String cateSeq, String keyword, String cateName, Pageable pageable) {
        Page<CompanyListResponse> result = companyRepository.companyList(cateSeq, keyword, cateName, pageable);

        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        int totalCount = (int) result.getTotalElements();

        int dec = pageSize * pageNumber;
        for(CompanyListResponse companyListResponse : result) {
            companyListResponse.setRowNum(totalCount - dec);
            dec++;
        }
        return result;
    }

    /** 단체 상세조회 **/
    @Transactional
    public CompanyDetailResponse companyDetail(String companySeq, HttpServletRequest request) {
        CompanyEntity company = companyRepository.findById(companySeq).orElseThrow(CEntityNotFoundException.CCompanyNotFoundException::new);

        String imgUrl = null;
        if(!ObjectUtils.isEmpty(company.getImg())) {
            imgUrl = fileHandler.fileUrl(company.getImg(), request);
        }

        return new CompanyDetailResponse(company, imgUrl);
    }


    /** 단체 수정 **/
    @Transactional
    public void companyUpdate(CompanyUpdateRequest request) {
        System.out.println(">>>  : " + request);

        if (request.getArea().equals("강화군") || request.getArea().equals("옹진군")) {
            request.setArea("강화·옹진군");
        }

        // 단체 유효성 체크
        CompanyEntity company = companyRepository.findById(request.getCompanySeq())
                .orElseThrow(() -> new RuntimeException("단체 정보를 찾을 수 없습니다."));
        // 단체 중복 체크
        CompanyEntity name = companyRepository.findByName(request.getName());
        // 카테고리 조회
        CategoryEntity category = categoryRepository.findByCateName(request.getArea());

        boolean type = true;

        if (request.getType() == null) {
            type = company.isType();
        }else if (request.getType() == 0) {
            type = false;
        }

        // 단체가 중복이 아닐 때
        if (name == null || request.getName().equals(company.getName())) {

            if (request.getName() != null && !request.getName().equals("")) {
                company.updateName(request.getName());
            }
            if (request.getScript() != null && !request.getScript().equals("")) {
                company.updateScript(request.getScript());
            }
            if (request.getStartDate() != null && !request.getStartDate().equals("")) {
                company.updateStartDate(request.getStartDate());
            }
            if (request.getCreateNo() != null && !request.getCreateNo().equals("")) {
                company.updateCreateNo(request.getCreateNo());
            }
            if (request.getType() != null && !request.getType().equals("")) {
                company.updateType(type);
            }
            if (request.getHomeUrl() != null) {
                company.updateHomeUrl(request.getHomeUrl());
            }
            if (request.getCafeUrl() != null) {
                company.updateCafeUrl(request.getCafeUrl());
            }
            if (request.getCafeUrl() != null) {
                company.updateEmail(request.getEmail());
            }
            if (request.getTel() != null && !request.getTel().equals("")) {
                company.updateTel(request.getTel());
            }

            if (request.getArea() != null && !request.getArea().equals("")) {
                CategoryEntity cate = categoryRepository.findByCateName(request.getArea());
                List<ProgramEntity> program = programRepository.findByCompany(company);
                for (int idx = 0; idx < program.size(); idx++) {
                    List<CategoryInfoEntity> cateInfo = categoryInfoRepository.findByProgram(program.get(idx));
                    for (int i = 0; i<cateInfo.size(); i++) {
                        if (cateInfo.get(i).getCategory().getCateSeq().equals(company.getCategory().getCateSeq())) {
                            cateInfo.get(i).updateCategory(cate);
                        }
                    }
                }
                company.updateArea(category);
            }

            if (request.getAddressDetail() != null && !request.getAddressDetail().equals("")) {
                company.updateAddressDetail(request.getAddressDetail());
            }

            if (request.getImg() != null && !request.getImg().isEmpty()) {
                List<MultipartFile> images = new ArrayList<>();
                images.add(request.getImg());
                EFileManager img = fileManagerRepository.save(fileHandler.parse(images, "company-img").get(0));
                company.setImg(img);
            }
        // 단체가 중복일 때
        }else {
            throw new RuntimeException("이미 등록된 단체명입니다.");
        }
    }

    /** 단체 삭제 **/
    @Transactional
    public void companyDelete(List<String> companySeqList) {
        for (String companySeq:companySeqList) {
            CompanyEntity company = companyRepository.findById(companySeq).orElseThrow(() -> new RuntimeException("단체 정보를 찾을 수 없습니다."));
            company.deleteCompany();
            List<ProgramEntity> programList = programRepository.findByCompanyAndWithdrawal(company, false);
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
        }
    }

    /** 사용자 단체 상세조회 **/
    @Transactional
    public UserCompanyDetailResponse userCompanyDetail(String companySeq, HttpServletRequest request) {
        CompanyEntity company = companyRepository.findById(companySeq).orElseThrow(CEntityNotFoundException.CCompanyNotFoundException::new);
        List<ProgramEntity> programEntityList = programRepository.findByCompany(company);

        List<Map<String, Object>> programInfoList = new ArrayList<>();

        if(programEntityList!=null && programEntityList.size()!=0) {
            for(ProgramEntity programEntity : programEntityList) {
                Map<String, Object> programInfo = new HashMap<>();
                String imgUrl1=null;
                String imgUrl2=null;

                if(!ObjectUtils.isEmpty(programEntity.getImg1())) {
                    imgUrl1 = fileHandler.fileUrl(programEntity.getImg1(), request);
                }
                if(!ObjectUtils.isEmpty(programEntity.getImg2())) {
                    imgUrl2 = fileHandler.fileUrl(programEntity.getImg2(), request);
                }
                UserProgramDetailResponse program = new UserProgramDetailResponse(programEntity, imgUrl1, imgUrl2, null);

                List<String> type = new ArrayList<>();
                List<String> theme = new ArrayList<>();
                List<String> target = new ArrayList<>();

                String[] typeList = program.getType().split("\\|");
                String[] typeTheme = program.getTheme().split("\\|");
                String[] typeTarget = program.getTarget().split("\\|");

                int typeCount = 0;
                int themeCount = 0;
                int targetCount = 0;

                for (String proType:typeList) {
                    CategoryEntity cate = categoryRepository.findById(proType).orElseThrow(() -> new RuntimeException("교육유형 카테고리 정보를 찾을 수 없습니다."));
                    type.add(typeCount, cate.getCateName());
                    typeCount++;
                }

                for (String proTheme:typeTheme) {
                    CategoryEntity cate = categoryRepository.findById(proTheme).orElseThrow(() -> new RuntimeException("교육테마 카테고리 정보를 찾을 수 없습니다."));
                    theme.add(themeCount, cate.getCateName());
                    themeCount++;
                }

                for (String proTarget:typeTarget) {
                    CategoryEntity cate = categoryRepository.findById(proTarget).orElseThrow(() -> new RuntimeException("교육대상 카테고리 정보를 찾을 수 없습니다."));
                    target.add(targetCount, cate.getCateName());
                    targetCount++;
                }

                programInfo.put("programDetail", program);
                programInfo.put("type", type);
                programInfo.put("theme", theme);
                programInfo.put("target", target);
                programInfoList.add(programInfo);
            }
        }

        String imgUrl = null;
        if(!ObjectUtils.isEmpty(company.getImg())) {
            imgUrl = fileHandler.fileUrl(company.getImg(), request);
        }

        return new UserCompanyDetailResponse(company, imgUrl, programInfoList);
    }

}
