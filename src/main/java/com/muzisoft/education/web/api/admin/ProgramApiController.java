package com.muzisoft.education.web.api.admin;

import com.muzisoft.education.web.api.dto.admin.program.ProgramListRequest;
import com.muzisoft.education.web.api.dto.admin.program.ProgramListResponse;
import com.muzisoft.education.web.api.dto.admin.program.ProgramSaveRequest;
import com.muzisoft.education.web.api.dto.admin.program.ProgramUpdateRequest;
import com.muzisoft.education.web.service.program.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/admin/api")
@RequiredArgsConstructor
public class ProgramApiController {

    private final ProgramService programService;

    // 프로그램 신규등록
    @PostMapping("/program/save")
    public void programInsert(ProgramSaveRequest request) {
        programService.programInsert(request);
    }

    // 프로그램 목록조회
    @GetMapping("/program/list")
    public Page<ProgramListResponse> programList(ProgramListRequest request, @PageableDefault(sort = "programSeq", direction = Sort.Direction.DESC) Pageable pageable) {
        return programService.programList(request, pageable);
    }

    // 프로그램 상세조회
    @GetMapping("/program/detail")
    public Map<String, Object> programDetail(String programSeq, HttpServletRequest request) {
        return programService.programDetail(programSeq, request);
    }

    // 프로그램 수정
    @PostMapping("/program/update")
    public void programUpdate(ProgramUpdateRequest request) {
        programService.programUpdate(request);
    }

    // 프로그램 삭제
    @PostMapping("/program/delete")
    public void programDelete(@RequestParam(value="programSeq[]") ArrayList<String> programSeq) {
        programService.programDelete(programSeq);
    }

}
