package com.sevensevensgi.springsecurity.repository;

import com.sevensevensgi.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends  JpaRepository<User, Integer>{

    public User findByUsername(String username);
    public List<User> findByRole(String role);
}