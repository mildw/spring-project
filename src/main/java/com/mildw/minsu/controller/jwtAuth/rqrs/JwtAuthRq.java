package com.mildw.minsu.controller.jwtAuth.rqrs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtAuthRq {

    private String UserEmail;
    private String UserPassWord;

}
