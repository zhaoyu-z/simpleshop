package com.iamzzy.simpleshop.service;

import com.iamzzy.simpleshop.constant.Role;
import com.iamzzy.simpleshop.entity.User;
import com.iamzzy.simpleshop.jpa.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;

@Component
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User createUser(String displayName, String email, String rawPassword) {
        User user = _createUser(displayName, email, rawPassword);
        user.setRole(Role.USER);
        return user;
    }

    public User createSeller(String displayName, String email, String rawPassword) {
        User user = _createUser(displayName, email, rawPassword);
        user.setRole(Role.SELLER);
        return user;
    }

    private User _createUser(String displayName, String email, String rawPassword) {
        return User.builder()
                .displayName(displayName)
                .email(email)
                .password(passwordEncoder.encode(rawPassword))
                .createdTime(new Timestamp(System.currentTimeMillis()))
                .failedLoginAttempts(0)
                .twoFactorEnabled(false)
                .addresses(new ArrayList<>())
                .loginHistories(new ArrayList<>())
                .build();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
