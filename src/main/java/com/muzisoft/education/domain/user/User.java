package com.muzisoft.education.domain.user;

import com.muzisoft.education.domain.base.BaseTimeEntity;
import com.muzisoft.education.domain.common.enums.Role;
import com.muzisoft.education.utils.manager.SeqManager;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@DynamicInsert
@DynamicUpdate
@Entity
@Getter @Setter(value = AccessLevel.PROTECTED)
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USERS")
public class User extends BaseTimeEntity implements UserDetails {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_manager_user")
    @GenericGenerator(name = "seq_manager_user", strategy = "com.muzisoft.education.utils.manager.SeqManager", parameters = {
            @org.hibernate.annotations.Parameter(name = SeqManager.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_USER_SEQ_PARAMETER, value = "user_"),
            @org.hibernate.annotations.Parameter(name = SeqManager.NUMBER_FORMAT_PARAMETER, value = "%010d"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_COLUMN_PARAM, value = "seq")
    })
    @Column(nullable = false, updatable = false, length = 15)
    @Id
    private String seq;

    @OneToOne(fetch = LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(nullable = false, name = "userdetails_seq")
    private com.muzisoft.education.domain.user.UserDetails userDetails;

    @Column(nullable = false, unique = true, length = 200)
    private String userId;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(length = 20)
    private String username;

    @ElementCollection(fetch = EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();

    private String provider;

    public static User create(String userId, String password) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setRoles(Collections.singletonList(Role.USER));
        return user;
    }

    public static User create(String userId, String password, String provider) {
        User user = create(userId, password);
        user.setUserDetails(com.muzisoft.education.domain.user.UserDetails.create());
        user.setProvider(provider);
        return user;
    }

    public void update(String username) {
        setUsername(username);
    }

    public void changePassword(String passwordToChange) {
        setPassword(passwordToChange);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream().map((role) -> new SimpleGrantedAuthority(role.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
