package com.iamzzy.simpleshop.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class User {
    // general
    private Long id; // auto generate
    private String displayName;
    private String email; // for register and login
    private String password; // hashed
    private String phoneNumber;
    private Date dateOfBirth;
    private Boolean gender;
    private List<Address> addresses;
    private Timestamp createdTime; // only set when create user
    private Timestamp deletedTime; // soft delete, if null then not deleted
    private Timestamp lastActiveTime; // updates when close tab/log out

    // security
    private Role role;
    private Timestamp lastLoginTime; // updates when login
    private Timestamp lastPasswordChangeTime; // updates when change password
    private Integer failedLoginAttempts; // updates when login fails
    private Boolean twoFactorEnabled;
    private List<loginHistory> loginHistories; // updates when login

    // external
    private Integer googleId;
    private Integer githubId;
}
