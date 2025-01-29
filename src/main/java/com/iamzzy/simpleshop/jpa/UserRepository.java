package com.iamzzy.simpleshop.jpa;

import com.iamzzy.simpleshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String username);
}
