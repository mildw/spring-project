package com.mildw.minsu.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public UserEntity(String name){
        this.name = name;
    }

}
