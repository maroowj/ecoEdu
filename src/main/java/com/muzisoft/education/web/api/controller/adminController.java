package com.muzisoft.education.web.api.controller;


import com.muzisoft.education.domain.common.enums.Role;
import com.muzisoft.education.utils.CookieUtils;
import com.muzisoft.education.web.api.dto.common.TokenResponse;
import com.muzisoft.education.web.api.dto.user.LoginRequest;
import com.muzisoft.education.web.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class adminController {

    private final AuthService authService;

    // 관리자 메인 페이지(프로그램 현황)
    @GetMapping("")
    public String main() {
        return "/admin/program/list";
        /*return "redirect:admin/login";*/
    }

    // 관리자 로그인 페이지
    @PostMapping("/login")
    @ResponseBody
    public void adminLogin(@RequestBody LoginRequest request, HttpServletRequest req, HttpServletResponse response) {
        List<Role> role = new ArrayList<>();
        role.add(Role.ADMIN);
        CookieUtils.removeCookieExceptFor(req, response, "savedId");

        TokenResponse tokenResponse = authService.login(request);
        Cookie access_cookie = new Cookie("AccessToken", tokenResponse.getAccessToken());
        access_cookie.setMaxAge(-1);
        access_cookie.setPath("/");
        access_cookie.setHttpOnly(true);

        response.addCookie(access_cookie);

        Cookie refresh_cookie = new Cookie("RefreshToken", tokenResponse.getRefreshToken());
        if (Boolean.parseBoolean(request.getIsKeep())) {
            refresh_cookie.setMaxAge(60 * 60 * 24 * 7);
        } else {
            refresh_cookie.setMaxAge(-1);
        }
        refresh_cookie.setPath("/");
        refresh_cookie.setHttpOnly(true);
        response.addCookie(refresh_cookie);

        if (Boolean.parseBoolean(request.getIsKeep())) {
            Cookie keep = new Cookie("LoginKeep", request.getId());
            keep.setMaxAge(60 * 60 * 24 * 14); // 2주
            keep.setPath("/");
            response.addCookie(keep);
        } else {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("LoginKeep")) {
                        cookie.setValue(null);
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
        }

        if (Boolean.parseBoolean(request.getIsSave())) {
            Cookie save = new Cookie("savedId", request.getId());
            save.setMaxAge(60 * 60 * 24 * 14); // 2주
            save.setPath("/");
            response.addCookie(save);
        } else {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("savedId")) {
                        cookie.setValue(null);
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
        }

    }

    // 관리자 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return "redirect:/admin";
        }
        return "/admin/login";
    }


    // 관리자 로그인 페이지 sub
//    @GetMapping("/login")
//    public String loginPage() {
//        System.out.println(">>>"+SecurityContextHolder.getContext().getAuthentication());
//        if (SecurityContextHolder.getContext().getAuthentication()!=null) {
//            if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
//                return "redirect:/admin";
//            }else {
//                return "/admin/login";
//            }
//        }else {
//            return "/admin/login";
//        }
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            cookie.setValue(null);
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());

        return "redirect:/admin/login";
    }

    // 관리자 카테고리 관리-지역
    @GetMapping("/manage/category/area")
    public String areaManage() {
        return "/admin/category/area/manage";
    }

    // 관리자 카테고리 관리-대상
    @GetMapping("/manage/category/target")
    public String targetManage() {
        return "/admin/category/target/manage";
    }

    // 관리자 카테고리 관리-테마
    @GetMapping("/manage/category/theme")
    public String themeManage() {
        return "/admin/category/theme/manage";
    }

    // 관리자 카테고리 관리-유형
    @GetMapping("/manage/category/type")
    public String typeManage() {
        return "/admin/category/type/manage";
    }

    // 관리자 단체 관리
    @GetMapping("/manage/group")
    public String groupManage() {
        return "/admin/group/manage";
    }

    // 관리자 프로그램 관리
    @GetMapping("/manage/program")
    public String programManage() {
        return "/admin/program/manage";
    }

    // 관리자 수정요청 관리
    @GetMapping("/manage/edit")
    public String editManage() {
        return "/admin/edit/manage";
    }

}
