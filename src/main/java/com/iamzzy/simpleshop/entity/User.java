package com.iamzzy.simpleshop.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.iamzzy.simpleshop.constant.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Jacksonized
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    // general
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // auto generate

    @Column(nullable = false)
    private String displayName;

    @Column(nullable = false, unique = true)
    private String email; // for register and login

    @Column
    private String password; // hashed

    @Column
    private String phoneNumber;

    @Column
    private Date dateOfBirth;

    @Column
    private Boolean gender;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    @Column(nullable = false, updatable = false)
    private Timestamp createdTime; // only set when create user

    @Column
    private Timestamp deletedTime; // soft delete, if null then not deleted

    @Column
    private Timestamp lastActiveTime; // updates when close tab/log out

    // security
    @Column(nullable = false)
    private Role role;

    @Column
    private Timestamp lastLoginTime; // updates when login

    @Column
    private Timestamp lastPasswordChangeTime; // updates when change password

    @Column(nullable = false)
    private Integer failedLoginAttempts; // updates when login fails

    @Column(nullable = false)
    private Boolean twoFactorEnabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoginHistory> loginHistories; // updates when login

    // external
    @Column
    private Integer googleId;

    @Column
    private Integer githubId;
}
