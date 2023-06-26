package com.muzisoft.education.web.service.program;

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
import com.muzisoft.education.web.api.dto.admin.program.*;
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
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProgramService {

    private final ProgramRepository programRepository;
    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryInfoRepository categoryInfoRepository;
    private final FileManagerRepository fileManagerRepository;

    private final FileHandler fileHandler;

    // 이미지 저장 문제
    /** 프로그램 신규등록 **/
    @Transactional
    public void programInsert(ProgramSaveRequest request) {

        CompanyEntity company = companyRepository.findById(request.getCompanySeq())
                .orElseThrow(() -> new RuntimeException("단체 정보를 찾을 수 없습니다."));

        ProgramEntity proTitle = programRepository.findByTitle(request.getTitle());

        boolean costType = false;
        if (request.getCostType() == 1) {
            costType = true;
        }
        boolean telType = false;
        if (request.getTelType() == 1) {
            telType = true;
        }

        if (proTitle == null) {
            ProgramEntity program = programRepository.save(
                    ProgramEntity.builder()
                            .title(request.getTitle())
                            .company(company)
                            .script(request.getScript())
                            .target(request.getTarget())
                            .theme(request.getTheme())
                            .type(request.getType())
                            .area(request.getArea())
                            .eduTime(request.getEduTime())
                            .oneTime(request.getOneTime())
                            .memberCount(request.getMemberCount())
                            .schedule(request.getSchedule())
                            .method(request.getMethod())
                            .cost(request.getCost())
                            .costType(costType)
                            .tel(request.getTel())
                            .telType(telType)
                            .build()
            );
        if (request.getImg1() != null && !request.getImg1().isEmpty()) {
            List<MultipartFile> images = new ArrayList<>();
            images.add(request.getImg1());
            EFileManager img1 = fileManagerRepository.save(fileHandler.parse(images, "program-img").get(0));
            program.setImg1(img1);
        }

        if (request.getImg2() != null && !request.getImg2().isEmpty()) {
            List<MultipartFile> images = new ArrayList<>();
            images.add(request.getImg2());
            EFileManager img2 = fileManagerRepository.save(fileHandler.parse(images, "program-img").get(0));
            program.setImg2(img2);
        }

            //categoryInfo 저장

            String[] typeList = program.getType().split("\\|");
            String[] themeList = program.getTheme().split("\\|");
            String[] targetList = program.getTarget().split("\\|");

            System.out.println(">>>"+typeList);

            int typeCount = 0;
            int themeCount = 0;
            int targetCount = 0;

            for (String proType:typeList) {
                CategoryEntity cate = categoryRepository.findById(proType)
                        .orElseThrow(() -> new RuntimeException("교육유형 카테고리 정보를 찾을 수 없습니다."));
                CategoryInfoEntity categoryInfo = categoryInfoRepository.save(
                        CategoryInfoEntity.builder()
                                .category(cate)
                                .program(program)
                                .build()
                );
                typeCount++;
            }

            for (String theme:themeList) {
                CategoryEntity cate = categoryRepository.findById(theme)
                        .orElseThrow(() -> new RuntimeException("교육테마 카테고리 정보를 찾을 수 없습니다."));
                CategoryInfoEntity categoryInfo = categoryInfoRepository.save(
                        CategoryInfoEntity.builder()
                                .category(cate)
                                .program(program)
                                .build()
                );
                themeCount++;
            }

            for (String target:targetList) {
                CategoryEntity cate = categoryRepository.findById(target)
                        .orElseThrow(() -> new RuntimeException("교육대상 카테고리 정보를 찾을 수 없습니다."));
                CategoryInfoEntity categoryInfo = categoryInfoRepository.save(
                        CategoryInfoEntity.builder()
                                .category(cate)
                                .program(program)
                                .build()
                );
                targetCount++;
            }

            // 지역 저장
            CategoryInfoEntity categoryInfo = categoryInfoRepository.save(
                    CategoryInfoEntity.builder()
                            .category(company.getCategory())
                            .program(program)
                            .build()
            );

        }else {
            throw new RuntimeException("프로그램명이 중복되었습니다.");
        }
    }

    /** 프로그램 목록조회 **/
    @Transactional
    public Page<ProgramListResponse> programList(ProgramListRequest request, Pageable pageable) {

        Page<ProgramListResponse> programList = programRepository.programList(request, pageable);


//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//
//        int rowNum = (pageSize * pageNumber) + 1;

        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        int totalCount = (int) programList.getTotalElements();

        int dec = pageSize * pageNumber;

        String[] typeList = new String[0];
        String[] typeTheme = new String[0];
        String[] typeTarget = new String[0];

        int listSize = 0;

        for (ProgramListResponse response : programList.getContent()) {

            response.setRowNum(totalCount-dec);
            dec++;
//            response.setRowNum(rowNum);
//            rowNum++;

            typeList = response.getType().split("\\|");
            typeTheme = response.getTheme().split("\\|");
            typeTarget = response.getTarget().split("\\|");

            StringBuilder type = new StringBuilder();
            StringBuilder theme = new StringBuilder();
            StringBuilder target = new StringBuilder();

            for (String proType:typeList) {
                    CategoryEntity cate = categoryRepository.findById(proType).orElseThrow(() -> new RuntimeException("교육유형 카테고리 정보를 찾을 수 없습니다."));
                    type.append(cate.getCateName());
                    type.append(",");
                }
                programList.getContent().get(listSize).setType(type.substring(0, type.length()-1));

            for (String proTheme:typeTheme) {
                CategoryEntity cate = categoryRepository.findById(proTheme).orElseThrow(() -> new RuntimeException("교육테마 카테고리 정보를 찾을 수 없습니다."));
                theme.append(cate.getCateName());
                theme.append(",");
            }
            programList.getContent().get(listSize).setTheme(theme.substring(0, theme.length()-1));

            for (String proTarget:typeTarget) {
                CategoryEntity cate = categoryRepository.findById(proTarget).orElseThrow(() -> new RuntimeException("교육대상 카테고리 정보를 찾을 수 없습니다."));
                target.append(cate.getCateName());
                target.append(",");
            }
            programList.getContent().get(listSize).setTarget(target.substring(0, target.length()-1));

            listSize++;
        }

        return programList;
    }

    /** 프로그램 상세조회 **/
    @Transactional
    public Map<String, Object> programDetail(String programSeq, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        ProgramEntity foundProgram = programRepository.findById(programSeq).orElseThrow(CEntityNotFoundException.CProgramNotFoundException::new);

        String imgUrl1=null;
        String imgUrl2=null;

        if(!ObjectUtils.isEmpty(foundProgram.getImg1())) {
            imgUrl1 = fileHandler.fileUrl(foundProgram.getImg1(), request);
        }
        if(!ObjectUtils.isEmpty(foundProgram.getImg2())) {
            imgUrl2 = fileHandler.fileUrl(foundProgram.getImg2(), request);
        }

        ProgramDetailResponse program = new ProgramDetailResponse(foundProgram, imgUrl1, imgUrl2);

        if (program == null) {
            throw new RuntimeException("등록된 프로그램 정보가 없습니다.");
        }

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


        try {
            result.put("programDetail", program);
            result.put("type", type);
            result.put("theme", theme);
            result.put("target", target);
        } catch (Exception e) {
            throw new RuntimeException("프로그램 상세 정보 불러오기를 실패했습니다.");
        }


        return result;
    }


    /** 프로그램 수정 **/
    @Transactional
    public void programUpdate(ProgramUpdateRequest request) {
        System.out.println(">>>"+ request.getArea());
        // 프로그램 유효성 체크
        ProgramEntity program = programRepository.findById(request.getProgramSeq()).orElseThrow(() -> new RuntimeException("프로그램 정보를 찾을 수 없습니다."));
        // 프래그램 중복 체크
        ProgramEntity name = programRepository.findByTitle(request.getTitle());
        CompanyEntity company;

        if (request.getCompanySeq() == null) {
            company = program.getCompany();
        } else {
            company = companyRepository.findById(request.getCompanySeq()).orElseThrow(() -> new RuntimeException("단체 정보를 찾을 수 없습니다."));
        }

        List<CategoryInfoEntity> cateInfo = categoryInfoRepository.findByProgram(program);

        boolean cost = true;
        if (request.getCostType() == null) {
            cost = program.isCostType();
        }else if (request.getCostType() == 0){
            cost = false;
        }
        boolean tel = true;
        if (request.getTelType() == null) {
            tel = program.isTelType();
        }else if (request.getTelType() == 0){
            tel = false;
        }


        if (name == null || request.getTitle().equals(program.getTitle())) {

            if (request.getTitle() != null && !request.getTitle().equals("")) {
                program.updateTitle(request.getTitle());
            }
            if (request.getCompanySeq() != null && !request.getCompanySeq().equals("")) {
                program.updateCompany(company);
            }
            if (request.getScript() != null && !request.getScript().equals("")) {
                program.updateScript(request.getScript());
            }
            if(request.getArea() != null && !request.getArea().equals("")) {
                program.updateArea(request.getArea());
            }
            if (request.getTarget() != null && !request.getTarget().equals("")) {
                //기존 테마 리스트
                String[] targetList = program.getTarget().split("\\|");
                //기존 테마 리스트 삭제
                for (int i = 0; i < cateInfo.size(); i++) {
                    for (String target:targetList) {
                        if (cateInfo.get(i).getCategory().getCateSeq().equals(target)) {
                            categoryInfoRepository.delete(cateInfo.get(i));
                        }
                    }
                }

                //신규 cateIfo 등록
                targetList = null;
                targetList = request.getTarget().split("\\|");
                for (int i = 0; i < targetList.length; i++) {
                    CategoryEntity cate = categoryRepository.findById(targetList[i]).orElseThrow(() -> new RuntimeException("교육유형 카테고리 정보를 찾을 수 없습니다."));;
                    categoryInfoRepository.save(
                            CategoryInfoEntity.builder()
                                    .category(cate)
                                    .program(program)
                                    .build()
                    );
                }


                program.updateTarget(request.getTarget());
            }

            if (request.getTheme() != null && !request.getTheme().equals("")) {
                //기존 테마 리스트
                String[] themeList = program.getTheme().split("\\|");

                //기존 테마 리스트 삭제
                for (int i = 0; i < cateInfo.size(); i++) {
                    for (String theme:themeList) {
                        if (cateInfo.get(i).getCategory().getCateSeq().equals(theme)) {
                            categoryInfoRepository.delete(cateInfo.get(i));
                        }
                    }
                }

                //신규 cateIfo 등록
                themeList = null;
                themeList = request.getTheme().split("\\|");
                for (int i = 0; i < themeList.length; i++) {
                    CategoryEntity cate = categoryRepository.findById(themeList[i]).orElseThrow(() -> new RuntimeException("교육테마 카테고리 정보를 찾을 수 없습니다."));;
                    categoryInfoRepository.save(
                            CategoryInfoEntity.builder()
                                    .category(cate)
                                    .program(program)
                                    .build()
                    );
                }

                program.updateTheme(request.getTheme());
            }
            if (request.getType() != null && !request.getType().equals("")) {
                //기존 테마 리스트
                String[] typeList = program.getType().split("\\|");
                //기존 테마 리스트 삭제
                for (int i = 0; i < cateInfo.size(); i++) {
                    for (String eduType:typeList) {
                        if (cateInfo.get(i).getCategory().getCateSeq().equals(eduType)) {
                            categoryInfoRepository.delete(cateInfo.get(i));
                        }
                    }
                }

                //신규 cateIfo 등록
                typeList = null;
                typeList = request.getType().split("\\|");
                for (int i = 0; i < typeList.length; i++) {
                    CategoryEntity cate = categoryRepository.findById(typeList[i]).orElseThrow(() -> new RuntimeException("교육유형 카테고리 정보를 찾을 수 없습니다."));;
                    categoryInfoRepository.save(
                            CategoryInfoEntity.builder()
                                    .category(cate)
                                    .program(program)
                                    .build()
                    );
                }

                program.updateType(request.getType());
            }
            if (request.getEduTime() != null && !request.getEduTime().equals("")) {
                program.updateEndTime(request.getEduTime());
            }
            if (request.getOneTime() != null && !request.getOneTime().equals("")) {
                program.updateOneTime(request.getOneTime());
            }
            if (request.getMemberCount() != null && !request.getMemberCount().equals("")) {
                program.updateMemberCount(request.getMemberCount());
            }
            if (request.getSchedule() != null && !request.getSchedule().equals("")) {
                program.updateSchedule(request.getSchedule());
            }
            if (request.getMethod() != null && !request.getMethod().equals("")) {
                program.updateMethod(request.getMethod());
            }
            if (request.getCost() != null && !request.getCost().equals("")) {
                program.updateCost(request.getCost());
            }
            if (request.getCostType() != null && !request.getCostType().equals("")) {
                program.updateCostType(cost);
            }
            if (request.getTel() != null && !request.getTel().equals("")) {
                program.updateTel(request.getTel());
            }
            if (request.getTelType() != null && !request.getTelType().equals("")) {
                program.updateTelType(tel);
            }

            if (request.getImg1() != null && !request.getImg1().isEmpty()) {
                List<MultipartFile> images = new ArrayList<>();
                images.add(request.getImg1());
                EFileManager img1 = fileManagerRepository.save(fileHandler.parse(images, "program-img").get(0));
                program.setImg1(img1);
            }

            if (request.getImg2() != null && !request.getImg2().isEmpty()) {
                List<MultipartFile> images = new ArrayList<>();
                images.add(request.getImg2());
                EFileManager img2 = fileManagerRepository.save(fileHandler.parse(images, "program-img").get(0));
                program.setImg2(img2);
            }

        }else {
            throw new RuntimeException("이미 등록된 프로그램명입니다.");
        }
    }

    /** 프로그램 삭제 **/
    @Transactional
    public void programDelete(List<String> programSeqList) {
        for(String programSeq : programSeqList){
            ProgramEntity program = programRepository.findById(programSeq).orElseThrow(() -> new RuntimeException("프로그램 정보를 찾을 수 없습니다."));

            // 카테고리와 연결된 프로그램이 있는 categoryInfo 테이블 record 값 삭제
            List<CategoryInfoEntity> categoryInfoList = categoryInfoRepository.findByProgram(program);
            for(CategoryInfoEntity categoryInfo: categoryInfoList) {
                categoryInfoRepository.delete(categoryInfo);
            }

            program.deleteProgram();
        }
    }


    /** 사용자 프로그램 상세조회 **/
    @Transactional
    public Map<String, Object> userProgramDetail(String programSeq, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        ProgramEntity foundProgram = programRepository.findById(programSeq).orElseThrow(CEntityNotFoundException.CProgramNotFoundException::new);

        String imgUrl1=null;
        String imgUrl2=null;

        if(!ObjectUtils.isEmpty(foundProgram.getImg1())) {
            imgUrl1 = fileHandler.fileUrl(foundProgram.getImg1(), request);
        }
        if(!ObjectUtils.isEmpty(foundProgram.getImg2())) {
            imgUrl2 = fileHandler.fileUrl(foundProgram.getImg2(), request);
        }

        CompanyEntity company = foundProgram.getCompany();
        String companyImgUrl = null;
        if(!ObjectUtils.isEmpty(company.getImg())) {
            companyImgUrl = fileHandler.fileUrl(company.getImg(), request);
        }

        UserProgramDetailResponse program = new UserProgramDetailResponse(foundProgram, imgUrl1, imgUrl2, companyImgUrl);

        if (program == null) {
            throw new RuntimeException("등록된 프로그램 정보가 없습니다.");
        }

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


        try {
            result.put("programDetail", program);
            result.put("type", type);
            result.put("theme", theme);
            result.put("target", target);
        } catch (Exception e) {
            throw new RuntimeException("프로그램 상세 정보 불러오기를 실패했습니다.");
        }


        return result;
    }
}
