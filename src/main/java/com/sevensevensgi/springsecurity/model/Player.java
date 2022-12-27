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
@Table(name = "player")
public class Player {

    @Id
    private Integer id;

    private Integer teamID;
    @ManyToOne
    private Game gameID;

    private String fullname;

}
