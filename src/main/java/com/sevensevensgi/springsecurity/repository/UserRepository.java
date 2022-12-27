package com.sevensevensgi.springsecurity.repository;

import com.sevensevensgi.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends  JpaRepository<User, Integer>{

    public User findByUsername(String username);
}