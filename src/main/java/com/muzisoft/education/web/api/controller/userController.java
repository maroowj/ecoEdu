package com.muzisoft.education.web.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class userController {

    // 사용자 메인 페이지(프로그램 현황)
    @GetMapping("/")
    public String main() {
        return "/user/index";
    }

    // 사용자 리스트(단체, 프로그램)
    @GetMapping("/list")
    public String listPage() {
        return "/user/list/list";
    }

    //단체 상세
    @GetMapping("/detail/group")
    public String groupDetail() {
        return "/user/detail/group";
    }

    //프로그램 상세
    @GetMapping("/detail/program")
    public String programDetail() {
        return "/user/detail/program";
    }

    //환경센터 소개
    @GetMapping("/info/center")
    public String centerInfo() {
        return "/user/info/center";
    }

    //정보수정 요청
    @GetMapping("/list/edit")
    public String editList() {
        return "/user/edit/list";
    }

}
