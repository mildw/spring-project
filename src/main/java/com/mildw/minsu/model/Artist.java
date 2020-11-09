package com.mildw.minsu.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter @Getter
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date Debut;
    private String genre;

}
