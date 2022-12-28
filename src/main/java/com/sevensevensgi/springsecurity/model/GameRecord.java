package com.sevensevensgi.springsecurity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@EqualsAndHashCode
@ToString
@Table(name = "gamerecord")
public class GameRecord {

    @Id
    private Integer id;

//    private Integer gameID;
    @ManyToOne
    private Game gameID;

//    private String schedule;
    private Date date;

    private String time;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
