package com.sevensevensgi.springsecurity.repository;

import com.sevensevensgi.springsecurity.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends  JpaRepository<Player, Integer>{

    public List<Player> findByTeamID(Integer id);
}