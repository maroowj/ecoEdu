package com.muzisoft.education.utils;

import com.muzisoft.education.domain.user.User;
import com.muzisoft.education.domain.user.UserRepository;
import com.muzisoft.education.web.exception.business.CEntityNotFoundException.CUserNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;

public class EntityUtils {
    public static User userThrowable(UserRepository userRepository) {
        return userRepository.findById(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getSeq())
                .orElseThrow(CUserNotFoundException::new);
    }
    public static User userThrowable(UserRepository userRepository, String seq) {
        return userRepository.findById(seq)
                .orElseThrow(CUserNotFoundException::new);
    }
}
