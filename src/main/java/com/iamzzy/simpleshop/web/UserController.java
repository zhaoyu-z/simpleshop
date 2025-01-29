package com.iamzzy.simpleshop.web;

import com.iamzzy.simpleshop.entity.User;
import com.iamzzy.simpleshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestParam String displayName,
                                           @RequestParam String email,
                                           @RequestParam String rawPassword) {
        User user = userService.createUser(displayName, email, rawPassword);
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }
}
