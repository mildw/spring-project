package com.mildw.minsu.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long sn;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String name;

}
