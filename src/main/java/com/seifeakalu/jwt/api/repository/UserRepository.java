package com.seifeakalu.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seifeakalu.jwt.api.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
}
