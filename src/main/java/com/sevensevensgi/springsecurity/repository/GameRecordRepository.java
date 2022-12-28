package com.sevensevensgi.springsecurity.repository;

import com.sevensevensgi.springsecurity.model.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface GameRecordRepository extends JpaRepository<GameRecord, Integer> {

    List<GameRecord> findByDateAfterOrderByDate(Date date);

    List<GameRecord> findByDate(Date date);

}
