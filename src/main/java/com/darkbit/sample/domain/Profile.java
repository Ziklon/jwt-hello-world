package com.darkbit.sample.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Profile {



    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String photo;

    private Integer age;

}
