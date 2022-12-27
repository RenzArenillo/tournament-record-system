package com.sevensevensgi.springsecurity.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@EqualsAndHashCode
@ToString
@Table(name = "gamerecordresult")
public class GameRecordResult {

    @Id
    private Integer id;

    private Integer gamerecordID;

    private Integer teamID;

    private Integer officialID;

    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGamerecordID() {
        return gamerecordID;
    }

    public void setGamerecordID(Integer gamerecordID) {
        this.gamerecordID = gamerecordID;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getOfficialID() {
        return officialID;
    }

    public void setOfficialID(Integer officialID) {
        this.officialID = officialID;
    }
}
