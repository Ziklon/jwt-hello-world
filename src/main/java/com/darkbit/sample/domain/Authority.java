package com.darkbit.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AUTHORITY")
@Data
public class Authority {


    public static  enum Rol {
        ROLE_USER,ROLE_ADMIN;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;


    @Column(name = "NAME")
    @Enumerated(EnumType.STRING)
    private Rol name;


    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<User> users;



}
