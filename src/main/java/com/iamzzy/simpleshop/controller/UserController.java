package com.iamzzy.simpleshop.controller;

import com.iamzzy.simpleshop.controller.model.ResponseBody;
import com.iamzzy.simpleshop.controller.validation.Password;
import com.iamzzy.simpleshop.entity.User;
import com.iamzzy.simpleshop.service.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseBody> createUser(
            @RequestParam @NotEmpty(message = "displayName must not be empty") String displayName,
            @RequestParam @Email(message = "Please provide a valid email address") String email,
            @RequestParam @Password String rawPassword
    ) {
        if (userService.userExists(email)) {
            return ResponseBody.withMessage(HttpStatus.CONFLICT, "User with email " + email + " already exists");
        }
        User user = userService.createUser(displayName, email, rawPassword);
        userService.saveUser(user);
        return ResponseBody.withData(HttpStatus.CREATED, user);
    }
}
