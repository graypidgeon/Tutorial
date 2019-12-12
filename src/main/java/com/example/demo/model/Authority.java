package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AuthorityType name;

}