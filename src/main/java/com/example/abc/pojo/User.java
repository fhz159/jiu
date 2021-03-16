package com.example.abc.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "NAME")
    private String name;
}
