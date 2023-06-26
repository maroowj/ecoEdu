package com.muzisoft.education.web.service.security;

import com.muzisoft.education.domain.user.UserRepository;
import com.muzisoft.education.web.exception.business.CEntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
        return userRepository.findById(userPk).orElseThrow(CEntityNotFoundException.CUserNotFoundException::new);
    }
}
