package com.sevensevensgi.springsecurity.repository;

import com.sevensevensgi.springsecurity.model.GameRecordResult;
import com.sevensevensgi.springsecurity.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRecordResultsRepository extends JpaRepository<GameRecordResult, Integer> {
    public List<GameRecordResult> findByTeamID(Integer id);

}
