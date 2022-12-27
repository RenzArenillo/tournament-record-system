package com.sevensevensgi.springsecurity.repository;

import com.sevensevensgi.springsecurity.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends  JpaRepository<Team, Integer>{

}