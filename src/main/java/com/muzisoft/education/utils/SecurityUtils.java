package com.muzisoft.education.utils;

import com.muzisoft.education.domain.user.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static User user() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
