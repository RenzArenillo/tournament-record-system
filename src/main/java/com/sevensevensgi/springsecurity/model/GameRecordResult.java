package com.sevensevensgi.springsecurity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode
@ToString
@Table(name = "gamerecordresult")
public class GameRecordResult {

    @Id
    private Integer id;

    @ManyToOne
    private GameRecord gamerecordID;

    @ManyToOne
    private Team teamID;
    @ManyToOne
    private User officialID;

    private Integer score;

}
